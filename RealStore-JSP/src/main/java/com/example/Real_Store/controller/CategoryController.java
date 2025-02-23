package com.example.Real_Store.controller;

import com.example.Real_Store.dto.*;
import com.example.Real_Store.entity.Cart;
import com.example.Real_Store.entity.Category;
import com.example.Real_Store.entity.Product;
import com.example.Real_Store.service.CategoryService;
import com.example.Real_Store.service.ProductService;
import com.example.Real_Store.service.UserService;
import com.example.Real_Store.validation.AdminValidations;
import com.example.Real_Store.validation.UserValidations;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class CategoryController {

    @Autowired
    public UserService userService;
    @Autowired
    public CategoryService categoryService;
    @Autowired
    public ProductService productService;
    @Autowired
    public UserValidations userValidations;
    @Autowired
    public AdminValidations adminValidations;

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return ResponseEntity.ok("start");
    }

    @RequestMapping("/")
    public String start(){
        return "start";
    }

    @RequestMapping("/regUser")
    public String regUser(Model model){
        CustomerDTO customerDTO = new CustomerDTO();
        model.addAttribute("user", customerDTO);
        return "registrationForm";
    }

    @RequestMapping("/registerUser")
    public String registerUser(@Valid @ModelAttribute ("user") CustomerDTO customerDTO, BindingResult bindingResult){
        System.out.println(customerDTO);
        userValidations.validate(customerDTO,bindingResult);
        if(bindingResult.hasErrors()){
            return "registrationForm";
        }
        userService.registerUser(customerDTO);
        return "redirect:/userLogins";
    }

    @RequestMapping("regAdmin")
    public String regAdmin(Model model){
        AdminDTO adminDTO = new AdminDTO();
        model.addAttribute("admin",adminDTO);
        return "adminRegistrationForm";
    }

    @RequestMapping("registerAdmin")
    public String registerAdmin(@Valid @ModelAttribute("admin") AdminDTO adminDTO,BindingResult bindingResult){

        adminValidations.validate(adminDTO,bindingResult);
        if(bindingResult.hasErrors()){
            return "adminRegistrationForm";
        }
        userService.registerAdmin(adminDTO);
        return "redirect:/adminLogins";
    }

    @RequestMapping("/userLogins")
    public String userLogin(Model model) {
        CustomerDTO customerDTO = new CustomerDTO();
        model.addAttribute("user", customerDTO);
        return "userLoginForm";
    }

    @RequestMapping("/adminLogins")
    public String adminLogin(Model model) {
        AdminDTO adminDTO = new AdminDTO();
        model.addAttribute("admin",adminDTO);
        return "adminLogin";
    }

    @RequestMapping("verifyUserCredentials")
    public String verifyUserCredential( @RequestParam String userName, @RequestParam String password,Model model){
        CustomerDTO customerDTO = userService.verifyUserCredential(userName,password);
        if(Objects.nonNull(customerDTO)){
            model.addAttribute("user", customerDTO);
            model.addAttribute("userId", customerDTO.getUserId());

            return "redirect:/userDashboard?userId="+ customerDTO.getUserId();
        }
        return null;
    }

    @RequestMapping("verifyAdminCredentials")
    public String verifyAdminCredential(@RequestParam String adminName, @RequestParam String password,Model model){
        AdminDTO adminDTO = userService.verifyAdminCredential(adminName,password);
        if(Objects.nonNull(adminDTO)){
            model.addAttribute("admin",adminDTO);
            model.addAttribute("adminId",adminDTO.getAdminId());

            return "redirect:/adminDashboard?adminId="+adminDTO.getAdminId();
        }
        return "invalidCredentials";
    }

    @RequestMapping("userDashboard")
    public String userDashboard(@RequestParam("userId")Long userId, Model model){
        CustomerDTO userDTO = userService.getUserById(userId);
        if(Objects.nonNull(userDTO)){
            List<Category> categoryList = categoryService.getAllCategory();
            List<Product> productList = productService.getAllProduct();
            model.addAttribute("categoryList",categoryList);
            model.addAttribute("productList",productList);
            model.addAttribute("user",userDTO);
        }
        return "userDashboard";
    }

    @RequestMapping("adminDashboard")
    public String adminDashboard(@RequestParam("adminId") Long adminId, Model model){
        AdminDTO adminDTO = userService.getAdminById(adminId);
        if(Objects.nonNull(adminDTO)){
            List<Category> categoryList = categoryService.getAllCategory();
            model.addAttribute("categoryList",categoryList);
            model.addAttribute("admin",adminDTO);
        }
        return "adminDashboard";
    }

    @RequestMapping("addCategory")
    public String addCategory(@RequestParam("adminId") Long adminId,Model model){
        CategoryDTO categoryDTO = new CategoryDTO();
        model.addAttribute("categoryDTO",categoryDTO);
        model.addAttribute("adminId",adminId);
        return "addCategoryForm";
    }

    @RequestMapping("saveCategory")
    public String saveCategory (@RequestParam("adminId") Long adminId,@ModelAttribute("categoryDTO") CategoryDTO categoryDTO,Model model){
        userService.saveCategory(categoryDTO);
        model.addAttribute("adminId",adminId);
        return "redirect:/adminDashboard?adminId="+adminId;
    }

    @RequestMapping("showProductList")
    public String showProductList(@RequestParam("categoryId")Long categoryId,@RequestParam("adminId")Long adminId,Model model){
        CategoryDTO categoryDTO = userService.getCategoryById(categoryId);
        List<ProductDTO> productDTOList = productService.getProductsByCategoryId(categoryId);
        model.addAttribute("productList",productDTOList);
        model.addAttribute("category",categoryDTO);
        model.addAttribute("categoryId",categoryId);
        model.addAttribute("adminId",adminId);
        return "showProductListForm";
    }

    @RequestMapping("submitSelectedProducts")
    public String submitSelectedProducts(@RequestParam("productIds") List<Long> productIds,
                                         @RequestParam("userId") Long userId,
                                         Model model){
        List<Product> selectedProductsOfUser = productService.getProductsById(productIds);
        model.addAttribute("selectedProductsOfUser",selectedProductsOfUser);
        model.addAttribute("userId",userId);
        model.addAttribute("productIds",productIds);
        return "cartForm";
    }

    @RequestMapping("checkQuantity" )
    public String checkQuantity(@RequestParam("userId") Long userId, @RequestParam("stockQuantity")Double givenQuantity, @RequestParam("productId")Long productId,@RequestParam("productIds") List<Long> productIds, Model model){
        boolean checkQuantity = productService.checkQuantity(userId,productId,givenQuantity,productIds);
        if(checkQuantity){
            List<Cart> cartList = productService.getProductsOfUser(userId);
            System.out.println(cartList);
            model.addAttribute("cartList",cartList);
            model.addAttribute("userId",userId);
            model.addAttribute("productIds",productIds);
            return "viewFinalCart";
        }
        return "adminLogin";
    }














//    @RequestMapping("submitSelectedProducts")
//    public String submitSelectedProducts(@RequestParam("productIds") List<Long> productIds,
//                                         @RequestParam("userId") Long userId,
//                                         Model model) {
//
//        if(productIds==null){
//            StringBuilder product = new StringBuilder();
//            for (Long product1 : productIds) {
//                Product p = productService.getProductById(product1);
//                if (product.length() > 0 && viewFinalProductList.contains(p)) {
//                    product.append("&");
//                }
//                product.append("selectedProducts=").append(product1);
//            }
//            return "redirect:/viewFinalCart?userId=" + userId + "&" + product.toString()+ "&" + "productId=" + product;
//        }
//        List<Product> selectedProductList = productService.getProductsById(productIds);
//        model.addAttribute("selectedProductList", selectedProductList);
//        model.addAttribute("productIds", productIds);
//        model.addAttribute("userId", userId);
//        model.addAttribute("productPriceMap1",productPriceMap);
//        return "cartForm";
//    }
//
//    @RequestMapping("checkQuantity")
//    public String checkQuantity(@RequestParam("productIds")List<Long> productIds,
//                                @RequestParam("productId") Long productId,
//                                @RequestParam("userId") Long userId,
//                                @RequestParam("stockQuantity") int stockQuantity,
//                                Model model) {
//        if (productService.checkQuantity(stockQuantity, productId, userId, selectedProductList, productIds, viewFinalList, viewFinalProductList)) {
//            List<Product>viewFinal=productService.getProduct(productId);
//            viewFinalProductList = productService.getFinalProducts(viewFinalList,productId,stockQuantity,selectedProductList,productPriceMap);
//            model.addAttribute("viewFinal",viewFinal);
//            model.addAttribute("selectedProducts",selectedProductList);
//            model.addAttribute("productId",productId);
//            model.addAttribute("userId",userId);
//            model.addAttribute("stockQuantity",stockQuantity);
//            model.addAttribute("productIds",productIds);
//            model.addAttribute("viewFinalProductList",viewFinalProductList);
//            model.addAttribute("productPriceMap2",productPriceMap);
//            return "viewFinalCart";
//        }
//       else{
//           return "invalidStockQuantity";
//        }
//    }


}
