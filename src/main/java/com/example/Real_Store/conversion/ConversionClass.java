package com.example.Real_Store.conversion;

import com.example.Real_Store.dto.*;
import com.example.Real_Store.entity.*;
import org.springframework.stereotype.Component;
//
@Component
public class ConversionClass {
//    public Customer CustomerDTO_To_CustomerEntity(CustomerDTO customerDTO){
//        Customer customer = new Customer();
//        customer.setCustomerId(customerDTO.getCustomerId());
//        customer.setFirstName(customerDTO.getFirstName());
//        customer.setLastName(customerDTO.getLastName());
//        customer.setAddress(customerDTO.getAddress());
//        customer.setPhoneNo(customerDTO.getPhoneNo());
//        customer.setEmail(customerDTO.getEmail());
//        return customer;
//    }
//    public CustomerDTO CustomerEntity_To_CustomerDTO(Customer customer){
//        CustomerDTO customerDTO  = new CustomerDTO();
//        customerDTO.setCustomerId(customer.getCustomerId());
//        customerDTO.setFirstName(customer.getFirstName());
//        customerDTO.setLastName(customer.getLastName());
//        customerDTO.setAddress(customer.getAddress());
//        customerDTO.setPhoneNo(customer.getPhoneNo());
//        customerDTO.setEmail(customer.getEmail());
//        customerDTO.setProductList(customer.getProductList());
//        return customerDTO;
//    }
//
//    public Category CategoryDTO_To_CategoryEntity(CategoryDTO categoryDTO){
//        Category category = new Category();
//        category.setCategoryId(categoryDTO.getCategoryId());
//        category.setName(categoryDTO.getName());
//        category.setDescription(categoryDTO.getDescription());
//        return category;
//    }
    public CategoryDTO CategoryEntity_To_CategoryDTO(Category category){
        CategoryDTO categoryDTO= new CategoryDTO();
        categoryDTO.setCategoryId(category.getCategoryId());
        categoryDTO.setName(category.getName());
        categoryDTO.setDescription(category.getDescription());
        return categoryDTO;
    }
//    public void BookingDTO_To_BookingEntity(BookingDTO bookingDTO, Booking booking){
//        booking.setOrderId(bookingDTO.getOrderId());
//        booking.setDate(bookingDTO.getDate());
//        booking.setOrderStatus(bookingDTO.getOrderStatus());
//        booking.setTotalAmount(bookingDTO.getTotalAmount());
//        booking.setPaymentStatus(bookingDTO.getPaymentStatus());
//    }
//    public void BookingEntity_To_BookingDTO(Booking booking, BookingDTO bookingDTO){
//        bookingDTO.setOrderId(booking.getOrderId());
//        bookingDTO.setDate(booking.getDate());
//        bookingDTO.setOrderStatus(booking.getOrderStatus());
//        bookingDTO.setTotalAmount(booking.getTotalAmount());
//        bookingDTO.setPaymentStatus(booking.getPaymentStatus());
//    }
//    public void PaymentDTO_To_Payment(PaymentDTO paymentDTO, Payment payment){
//        payment.setReferenceId(paymentDTO.getReferenceId());
//        payment.setPaymentAmount(paymentDTO.getPaymentAmount());
//        payment.setPaymentDate(paymentDTO.getPaymentDate());
//        payment.setPaymentMethod(paymentDTO.getPaymentMethod());
//        payment.setPaymentStatus(paymentDTO.getPaymentStatus());
//    }
//    public void Payment_To_PaymentDTO(Payment payment, PaymentDTO paymentDTO){
//        paymentDTO.setReferenceId(payment.getReferenceId());
//        paymentDTO.setPaymentAmount(payment.getPaymentAmount());
//        paymentDTO.setPaymentDate(paymentDTO.getPaymentDate());
//        paymentDTO.setPaymentMethod(payment.getPaymentMethod());
//        paymentDTO.setPaymentStatus(payment.getPaymentStatus());
//    }
    public Product ProductDTO_To_Product(ProductDTO productDTO){
        Product product = new Product();
        product.setProductId(productDTO.getProductid());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setStockQuantity(productDTO.getStockQuantity());
        product.setDescription(productDTO.getDescription());
        product.setProductStatus(productDTO.getProductStatus());
        product.setStockStatus(productDTO.getStockStatus());
        return product;
    }
    public ProductDTO Product_To_ProductDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductid(product.getProductId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setStockQuantity(product.getStockQuantity());
        productDTO.setCategoryName(product.getCategory().getName());//method1
        productDTO.setProductStatus(product.getProductStatus());
        productDTO.setStockStatus(product.getStockStatus());
//        productDTO.setCustomerName(product.getCustomer().getFirstName());
        productDTO.setDescription(product.getDescription());
//        productDTO.setCategory(product.getCategory());   method2
        return productDTO;
    }
}

