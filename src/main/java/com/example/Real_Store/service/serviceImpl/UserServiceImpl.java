package com.example.Real_Store.service.serviceImpl;

import com.example.Real_Store.dto.AdminDTO;
import com.example.Real_Store.dto.CategoryDTO;
import com.example.Real_Store.dto.CustomerDTO;
import com.example.Real_Store.entity.Admin;
import com.example.Real_Store.entity.Category;
import com.example.Real_Store.entity.Customer;
import com.example.Real_Store.repository.AdminRepository;
import com.example.Real_Store.repository.CategoryRepository;
import com.example.Real_Store.repository.UserRepository;
import com.example.Real_Store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserRepository userRepository;

    @Autowired
    public AdminRepository adminRepository;

    @Autowired
    public CategoryRepository categoryRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    public void registerUser(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setUserName(customerDTO.getUserName());
        customer.setPassword(passwordEncoder.encode(customerDTO.getPassword()));
        customer.setEmail(customerDTO.getEmail());
        customer.setMobile(customerDTO.getMobile());
        userRepository.save(customer);
    }

    @Override
    public void registerAdmin(AdminDTO adminDTO) {
        Admin admin = new Admin();
        admin.setAdminName(adminDTO.getAdminName());
        admin.setPassword(passwordEncoder.encode(adminDTO.getPassword()));
//        admin.setPassword(adminDTO.getPassword());
        admin.setEmail(adminDTO.getEmail());
        admin.setMobile(adminDTO.getMobile());
        adminRepository.save(admin);
    }

    @Override
    public CustomerDTO verifyUserCredential(String userName, String password) {
        Customer customer = userRepository.findAll().stream()
                .filter(customer1 -> customer1.getUserName().equals(userName))
                .findFirst()
                .orElse(null);

        if (customer != null && passwordEncoder.matches(password, customer.getPassword())) {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setUserId(customer.getUserId());
            customerDTO.setUserName(customer.getUserName());
            customerDTO.setPassword(customer.getPassword());
            customerDTO.setMobile(customer.getMobile());
            customerDTO.setEmail(customer.getEmail());
            return customerDTO;
        }
        return null;
    }

    @Override
    public AdminDTO verifyAdminCredential(String adminName, String password) {
        Admin admin = adminRepository.findAll().stream()
                .filter(admin1 -> admin1.getAdminName().equals(adminName))
                .findFirst()
                .orElse(null);
        if(Objects.nonNull(admin) && passwordEncoder.matches(password,admin.getPassword())){
            AdminDTO adminDTO = new AdminDTO();
            adminDTO.setAdminId(admin.getAdminId());
            adminDTO.setAdminName(admin.getAdminName());
            adminDTO.setPassword(admin.getPassword());
            adminDTO.setMobile(admin.getMobile());
            adminDTO.setEmail(admin.getEmail());
            return adminDTO;
        }
        return null;
    }

    @Override
    public AdminDTO getAdminById(Long adminId) {
        Admin admin = adminRepository.findById(adminId).get();
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setAdminId(admin.getAdminId());
        adminDTO.setAdminName(admin.getAdminName());
        adminDTO.setPassword(admin.getPassword());
        adminDTO.setMobile(admin.getMobile());
        adminDTO.setEmail(admin.getEmail());
        return adminDTO;
    }

    @Override
    public void saveCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setCategoryId(categoryDTO.getCategoryId());
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        categoryRepository.save(category);
    }

    @Override
    public CategoryDTO getCategoryById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).get();
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryId(category.getCategoryId());
        categoryDTO.setName(category.getName());
        categoryDTO.setDescription(category.getDescription());
        return categoryDTO;
    }

    @Override
    public CustomerDTO getUserById(Long userId) {
        Customer customer = userRepository.findById(userId).get();
        CustomerDTO userDTO = new CustomerDTO();
        userDTO.setUserId(customer.getUserId());
        userDTO.setUserName(customer.getUserName());
        userDTO.setPassword(customer.getPassword());
        userDTO.setEmail(customer.getEmail());
        userDTO.setMobile(customer.getMobile());
        return userDTO;
    }




}
