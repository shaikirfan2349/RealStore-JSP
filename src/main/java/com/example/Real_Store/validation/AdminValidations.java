package com.example.Real_Store.validation;

import com.example.Real_Store.dto.AdminDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AdminValidations implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return AdminDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AdminDTO adminDTO = (AdminDTO) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"adminName","notEmpty.adminName");
        if(adminDTO.getAdminName() != null && !adminDTO.getAdminName().isBlank()){
            if(adminDTO.getAdminName().length()>10){
                errors.rejectValue("adminName","length.admin.adminName","Admin Name not exceed 10 characters ");
            } if (!adminDTO.getAdminName().matches(".*\\d.*")) {
                errors.rejectValue("adminName", "digit.admin.adminName", "Admin Name must contain at least one digit.");
            } else if (adminDTO.getAdminName().matches("\\d+")) {
                errors.rejectValue("adminName","digit.admin.adminName","Admin Name should not entirely numeric");
            }
        } else if (adminDTO.getAdminName() != null && adminDTO.getAdminName().isBlank()) {
            errors.rejectValue("adminName","errors","AdminName cannot be Blank");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","notEmpty.password","password is required");
        if(adminDTO.getPassword() != null && !adminDTO.getPassword().isBlank()){
            if(adminDTO.getPassword().length() > 6 ){
                errors.rejectValue("password","password.length","password should contain at least 7 characters");
            } else if (adminDTO.getPassword().matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-]).+$")){
                errors.rejectValue("password","password.check","password should contain atleast special character,capital letter,small letter,digit");
            }
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","notEmpty.email","mail should not be blank");
        if (adminDTO.getEmail() != null && !adminDTO.getEmail().matches("^[\\w.-]+@gmail\\.com$")) {
            errors.rejectValue("email", "format.email", "Email must be a valid Gmail address.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"mobile","notEmpty.mobile","mobile number should not be blank");
        if (adminDTO.getMobile() != null && !adminDTO.getMobile().matches("\\d{10}")) {
            errors.rejectValue("mobile", "mobile.check", "Mobile number must be 10 digits.");
        }
    }

}
