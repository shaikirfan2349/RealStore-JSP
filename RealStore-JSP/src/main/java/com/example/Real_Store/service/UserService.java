package com.example.Real_Store.service;

import com.example.Real_Store.dto.AdminDTO;
import com.example.Real_Store.dto.CategoryDTO;
import com.example.Real_Store.dto.CustomerDTO;
import com.example.Real_Store.entity.Product;

import java.util.List;

public interface UserService {
    void registerUser(CustomerDTO customerDTO);


    void registerAdmin(AdminDTO adminDTO);

    CustomerDTO verifyUserCredential(String userName, String password);

    AdminDTO verifyAdminCredential(String adminName, String password);

    AdminDTO getAdminById(Long adminId);

    void saveCategory(CategoryDTO categoryDTO);

    CategoryDTO getCategoryById(Long categoryId);

    CustomerDTO getUserById(Long userId);
}
