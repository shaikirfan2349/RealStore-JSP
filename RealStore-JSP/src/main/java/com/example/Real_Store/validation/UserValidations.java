package com.example.Real_Store.validation;

import com.example.Real_Store.dto.CustomerDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidations implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return CustomerDTO.class.equals(clazz);
    }
    @Override
    public void validate(Object target, Errors errors) {
        CustomerDTO customerDTO = (CustomerDTO) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "notEmpty.userName");
        if (customerDTO.getUserName() != null && !customerDTO.getUserName().isBlank()) {
            if (customerDTO.getUserName().length() > 10) {
                errors.rejectValue("userName", "length.user.userName", "Username cannot exceed 10 characters.");
            }
            if (!customerDTO.getUserName().matches(".*\\d.*")) {
                errors.rejectValue("userName", "digit.user.userName", "Username must contain at least one digit.");
            } else if (customerDTO.getUserName().matches("\\d+")) {
                errors.rejectValue("userName", "numeric.user.userName", "Username cannot be entirely numeric.");
            }
        } else if (customerDTO.getUserName() != null && customerDTO.getUserName().isBlank()) {
            errors.rejectValue("userName", "blank.user.userName", "Username cannot be blank.");
        }


        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","notEmpty.password","Password should not contain whitespaces");
        if(customerDTO.getPassword() != null && customerDTO.getPassword().isBlank()){
            if(customerDTO.getPassword().length() > 6 ){
                errors.rejectValue("password","password.length","password should contain at least 7 characters");
            } else if (customerDTO.getPassword().matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-]).+$")){
                errors.rejectValue("password","password.check","password should contain atleast special character,capital letter,small letter,digit");
            }
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"mobile","notEmpty.mobile","mobile number should not be blank");
        if (customerDTO.getMobile() != null && !customerDTO.getMobile().matches("\\d{10}")) {
            errors.rejectValue("mobile", "mobile.check", "Mobile number must be 10 digits.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","notEmpty.email","mail should not be blank");
        if (customerDTO.getEmail() != null && !customerDTO.getEmail().matches("^[\\w.-]+@gmail\\.com$")) {
            errors.rejectValue("email", "format.email", "Email must be a valid Gmail address.");
        }

    }
}
