package com.example.Real_Store.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long orderId;
    private Date date;
    private double totalAmount;
    private String paymentStatus;
    private String orderStatus;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "userId",referencedColumnName = "userId")
    public Customer customer;

//    @OneToOne(mappedBy = "booking",cascade = CascadeType.ALL)
//    @JsonManagedReference
//    public Payment payment;


//    @ManyToMany
//    @JsonBackReference
//    @JoinTable(name="productBookingTable",
//            joinColumns = @JoinColumn(name = "orderId"),
//            inverseJoinColumns = @JoinColumn(name = "productId"))
//    public List<Product> productList;



    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", date=" + date +
                ", totalAmount=" + totalAmount +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}
