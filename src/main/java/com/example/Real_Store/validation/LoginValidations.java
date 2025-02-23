package com.example.Real_Store.validation;

import com.example.Real_Store.dto.CustomerDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LoginValidations implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDTO customerDTO = (CustomerDTO) target;

//        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"userName","notEmpty.login","username can't be blank");
//        if(customerDTO.getUserName() != null && !customerDTO.getUserName().isBlank() ){
//            if(customerDTO.getUserName().)
//        }
    }
}
