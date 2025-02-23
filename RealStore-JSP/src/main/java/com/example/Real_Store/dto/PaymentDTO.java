//package com.example.Real_Store.dto;
//
//import jakarta.validation.constraints.NotBlank;
//
//import java.text.DateFormat;
//import java.util.Date;
//
//public class PaymentDTO {
//    private Long referenceId;
//    private double paymentAmount;
//    private Date paymentDate;
//    @NotBlank(message = "payment method should not be empty")
//    private String paymentMethod;
//    @NotBlank(message = "payment status should not be empty")
//    private String paymentStatus;
//
//    public Long getReferenceId() {
//        return referenceId;
//    }
//
//    public void setReferenceId(Long referenceId) {
//        this.referenceId = referenceId;
//    }
//
//    public double getPaymentAmount() {
//        return paymentAmount;
//    }
//
//    public void setPaymentAmount(double paymentAmount) {
//        this.paymentAmount = paymentAmount;
//    }
//
//
//    public String getPaymentMethod() {
//        return paymentMethod;
//    }
//
//    public void setPaymentMethod(String paymentMethod) {
//        this.paymentMethod = paymentMethod;
//    }
//
//    public String getPaymentStatus() {
//        return paymentStatus;
//    }
//
//    public void setPaymentStatus(String paymentStatus) {
//        this.paymentStatus = paymentStatus;
//    }
//
//
//    public Date getPaymentDate() {
//        return paymentDate;
//    }
//
//    public void setPaymentDate(Date paymentDate) {
//        this.paymentDate = paymentDate;
//    }
//}
