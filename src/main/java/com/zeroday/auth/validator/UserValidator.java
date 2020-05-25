package com.zeroday.auth.validator;

import com.zeroday.auth.model.User;
import com.zeroday.auth.model.payFees;
import com.zeroday.auth.model.Grade;
import com.zeroday.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import org.passay.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        if (user.getUsername().contains("'") || user.getUsername().contains("<") || user.getUsername().contains("<") || user.getUsername().contains("/")) {
            errors.rejectValue("username", "Type.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        String result = userPasswordValidation(user.getPassword());
        if(!result.equalsIgnoreCase("valid")){
            errors.rejectValue("password", null,result);
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
    }

    public void validateFees(Object o, Errors errors) {
        payFees user = (payFees) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cardNumber", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "securityCode", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cardName", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "expireDate", "NotEmpty");


        if (user.getCardNumber().length() != 16) {
            errors.rejectValue("cardNumber", "Size.payFees.cardNumber");
        }
        if (user.getSecurityCode().length() != 3) {
            errors.rejectValue("securityCode", "Size.payFees.securityCode");
        }
    }

    public void validateGrades(Object o, Errors errors){
        Grade thisGrade = (Grade) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "studentName", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "module", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "grade", "NotEmpty");


        if(!thisGrade.getStudentName().contains(" ")) {
            errors.rejectValue("studentName", "Fullname.newgrade.studentName");
        }
        if(thisGrade.getModule().length()>45){
            errors.rejectValue("module", "Size.newgrade.module");
        }
        if(thisGrade.getGrade()>100 || thisGrade.getGrade() < 0){
            errors.rejectValue("grade", "Size.newgrade.grade");
        }
    }

    private String userPasswordValidation(String passwordData){
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                new LengthRule(8, 100),
                new CharacterRule(EnglishCharacterData.UpperCase, 1),
                new CharacterRule(EnglishCharacterData.LowerCase, 1),
                new CharacterRule(EnglishCharacterData.Digit, 1),
                new CharacterRule(EnglishCharacterData.Special, 1)
        ));

        RuleResult result = validator.validate(new PasswordData(passwordData));
        if(!result.isValid()){
            return "invalid";
        }
        return "valid";
    }

}
