package com.example.Real_Store.controller;

import com.example.Real_Store.conversion.ConversionClass;
import com.example.Real_Store.dto.CategoryDTO;
import com.example.Real_Store.dto.ProductDTO;
import com.example.Real_Store.entity.Category;
import com.example.Real_Store.entity.Product;
import com.example.Real_Store.repository.CategoryRepository;
import com.example.Real_Store.service.CategoryService;
import com.example.Real_Store.service.ProductService;
import com.example.Real_Store.service.serviceImpl.ProductServiceImpl;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    public ProductService productService;
    @Autowired
    public ConversionClass conversionClass;
    @Autowired
    public CategoryService categoryService;


    @RequestMapping("/addProduct")
    public String addProduct(@RequestParam("categoryId") Long categoryId,@RequestParam("adminId")Long adminId, Model model){
        ProductDTO productDTO = new ProductDTO();
        CategoryDTO categoryDTO = categoryService.getCategoryById(categoryId);
        model.addAttribute("productDTO",productDTO);
        model.addAttribute("categoryDTO",categoryDTO);
        model.addAttribute("adminId",adminId);
        return "addProductForm";
    }
    @RequestMapping("/saveProduct")
    public String saveProduct(@RequestParam("categoryId")Long categoryId,@RequestParam("adminId")Long adminId, @ModelAttribute ("productDTO")ProductDTO productDTO, Model model){
        productService.saveProduct(productDTO,categoryId);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("adminId",adminId);
        return "redirect:/showProductList?categoryId=" + categoryId + "&adminId=" + adminId;
    }
}
