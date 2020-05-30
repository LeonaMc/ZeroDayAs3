package com.zeroday.auth.validator;

import com.zeroday.auth.model.User;
import com.zeroday.auth.model.payFees;
import com.zeroday.auth.model.Grade;
import com.zeroday.auth.service.WrongAttemptService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import org.passay.*;
import java.util.Arrays;

@Component
public class UserValidatorRegistration implements Validator {


    @Value("${restricted-passwords}")
    private String restrictedPasswords;

    @Autowired
    WrongAttemptService wrongAttemptService;

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
        if (wrongAttemptService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }
        if (!StringUtils.isAlphanumeric(user.getUsername())) {
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

        if(isPasswordFromRestrictedList(user.getPassword())) {
            errors.rejectValue("password", "Type.userForm.restrictedPassword");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty");
        if (!StringUtils.isAlpha(user.getFirstName())) {
            errors.rejectValue("firstName", "Type.userForm.firstname");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty");
        if (!StringUtils.isAlpha(user.getLastName())) {
            errors.rejectValue("lastName", "Type.userForm.lastname");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        if (user.getEmail().contains("'") || user.getEmail().contains("<") || user.getEmail().contains("<") || user.getEmail().contains("/") || !user.getEmail().contains("@edu.com")) {
            errors.rejectValue("email", "Type.userForm.email");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "studentNumber", "NotEmpty");
        if (!StringUtils.isNumeric(user.getStudentNumber())) {
            errors.rejectValue("studentNumber", "Type.userForm.studentnumber");
        }


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobileNum", "NotEmpty");
        if (user.getMobileNum().length() < 7) {
            errors.rejectValue("mobileNum", "Size.userForm.mobileNumShort");
        }else if(user.getMobileNum().length() > 30){
            errors.rejectValue("mobileNum", "Size.userForm.mobileNumLong");
        }
        if (!StringUtils.isNumeric(user.getMobileNum())) {
            errors.rejectValue("mobileNum", "Type.userForm.mobilenumber");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "homeNum", "NotEmpty");
        if (!StringUtils.isNumeric(user.getHomeNum())) {
            errors.rejectValue("homeNum", "Type.userForm.homenumber");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty");
        if (!StringUtils.isAlphanumericSpace(user.getAddress())) {
            errors.rejectValue("address", "Type.userForm.address");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "NotEmpty");
    }

    public boolean isPasswordFromRestrictedList(String password) {
        String[] passwords = restrictedPasswords.split(",");

        for(int i=0; i<passwords.length; i++) {
            if(password.equals(passwords[i])) {
                return true;
            }
        }

        return false;
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
        if (!StringUtils.isNumeric(user.getCardNumber())) {
            errors.rejectValue("cardNumber", "Type.payFees.cardNumber");
        }
        if (user.getSecurityCode().length() != 3) {
            errors.rejectValue("securityCode", "Size.payFees.securityCode");
        }
        if (!StringUtils.isNumeric(user.getSecurityCode())) {
            errors.rejectValue("securityCode", "Type.payFees.securityCode");
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
        if(thisGrade.getModule().getModule_name().length()>45){
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
            return "Invalid Password. Try Again.";
        }
        return "valid";
    }

}