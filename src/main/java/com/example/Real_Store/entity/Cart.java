package com.example.Real_Store.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long cartId;
    private Long userId;
    private Long productId;
    private String productName;
    private double requiredQuantity;
    private  double price;
    private double totalAmount;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.MERGE)
    @JsonManagedReference
    public List<Product> productList;

    @OneToOne
    public Customer customer;
}
