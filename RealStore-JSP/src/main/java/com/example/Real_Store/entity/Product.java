package com.example.Real_Store.entity;

import com.example.Real_Store.enumeration.StockStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String name;
    private double price;
    private int stockQuantity;
    private String description;
    private String productStatus;

    @Enumerated(EnumType.STRING)
    private StockStatus stockStatus;

    @ManyToOne
    @JoinColumn(name = "category_Id", referencedColumnName = "categoryId")
    @JsonBackReference
    public Category category;

    @ManyToOne
    @JoinColumn(name = "cartId",referencedColumnName = "cartId")
    @JsonBackReference
    public Cart cart;


//    @ManyToMany(mappedBy = "productList",cascade = CascadeType.ALL)
//    @JsonBackReference
//    public List<Customer> customerList;
//
//    @ManyToMany(mappedBy = "productList",cascade = CascadeType.ALL)
//    @JsonManagedReference
//    public List<Booking> bookingList ;

//    public Product(Long productId, String name, double price, int stockQuantity, String description, String productStatus, StockStatus stockStatus, Category category, List<Customer> customerList, List<Booking> bookingList) {
//        this.productId = productId;
//        this.name = name;
//        this.price = price;
//        this.stockQuantity = stockQuantity;
//        this.description = description;
//        this.productStatus = productStatus;
//        this.stockStatus = stockStatus;
//        this.category = category;
//        this.customerList = customerList;
//        this.bookingList = bookingList;
//    }

    public Product() {

    }

//    @Override
//    public String toString() {
//        return "Product{" +
//                "productId=" + productId +
//                ", name='" + name + '\'' +
//                ", price=" + price +
//                ", stockQuantity=" + stockQuantity +
//                ", description='" + description + '\'' +
//                ", productStatus='" + productStatus + '\'' +
//                ", stockStatus=" + stockStatus +
//                ", category=" + category +
//                ", customerList=" + customerList +
//                ", bookingList=" + bookingList +
//                '}';
//    }
}
