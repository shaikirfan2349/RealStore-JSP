package com.example.Real_Store.service;

import com.example.Real_Store.dto.ProductDTO;
import com.example.Real_Store.entity.Cart;
import com.example.Real_Store.entity.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {

        List<ProductDTO> getProductsByCategoryId(Long categoryId);


    void saveProduct(ProductDTO productDTO, Long categoryId);

    List<Product> getAllProduct();

    List<Product> getProductsById(List<Long> productIds);




    List<Long> removeCartProduct(List<Long> productIds, Long productId, Long userId);

//    List<Product> getProduct(Long productId);


//    List<Product> getFinalProducts(List<Long> viewFinalList, Long productId, int stockQuantity, List<Product> selectedProductList, Map<Long, Double> map);
//
//    Product getProductById(Long product1);

    Product getProductById(Long product1);

    boolean checkQuantity(Long userId, Long productId, Double givenQuantity, List<Long> productIds);

    List<Cart> getProductsOfUser(Long userId);
}
