package com.example.Real_Store.dto;

import jakarta.validation.constraints.NotBlank;

import java.text.DateFormat;
import java.util.Date;

public class BookingDTO {

    private Long orderId;
    private Date date;
    private double totalAmount;
    @NotBlank(message = "paymentStatus should not null")
    private String paymentStatus;
    @NotBlank(message = "orderStatus should not nulls")
    private String orderStatus;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public @NotBlank(message = "paymentStatus should not null") String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(@NotBlank(message = "paymentStatus should not null") String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public @NotBlank(message = "orderStatus should not nulls") String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(@NotBlank(message = "orderStatus should not nulls") String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
