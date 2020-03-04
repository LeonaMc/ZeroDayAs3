package com.zeroday.auth.validator;

import com.zeroday.auth.model.User;
import com.zeroday.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "studentNumber", "NotEmpty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobileNum", "NotEmpty");
        if (user.getMobileNum().length() < 7) {
            errors.rejectValue("mobileNum", "Size.userForm.mobileNumShort");
        }else if(user.getMobileNum().length() > 30){
            errors.rejectValue("mobileNum", "Size.userForm.mobileNumLong");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "homeNum", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "NotEmpty");

        // Commented out code is testing if Male and Female values are reading correctly
        /**     if (user.getGender().equals("F")) {
            errors.rejectValue("gender", "Size.userForm.mobileNumShort");
        }else if(user.getGender().equals("M")){
            errors.rejectValue("gender", "Size.userForm.mobileNumLong");
        } **/



    }
}
