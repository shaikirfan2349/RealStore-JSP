package com.example.Real_Store.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;
import java.util.Date;

@Entity
@Getter
@Setter
public class Payment {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long referenceId;
    private double paymentAmount;
    private Date paymentDate;
    private String paymentMethod;
    private String paymentStatus;

    @OneToOne
    @JoinColumn(name = "order_Id", referencedColumnName = "orderId")
    @JsonBackReference
    public Booking booking;

    public Payment(Long referenceId, double paymentAmount, Date paymentDate, String paymentMethod, String paymentStatus) {
        this.referenceId = referenceId;
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    public Payment() {

    }

    @Override
    public String toString() {
        return "Payment{" +
                "referenceId=" + referenceId +
                ", paymentAmount=" + paymentAmount +
                ", paymentDate=" + paymentDate +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }
}
