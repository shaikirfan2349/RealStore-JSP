package com.example.Real_Store.dto;

import com.example.Real_Store.entity.Category;
import com.example.Real_Store.enumeration.StockStatus;
//import com.jayway.jsonpath.internal.filter.ValueNodes;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductDTO {
    private Long productid;
    @NotBlank(message = "product name should not be empty")
    private String name;

    private double price;

    private int stockQuantity;
    @NotBlank(message = "description should not be empty")
    private String description;
    private String productStatus;
    private StockStatus stockStatus;
    public String categoryName;

    public String customerName;



    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public StockStatus getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(StockStatus stockStatus) {
        this.stockStatus = stockStatus;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productid=" + productid +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", description='" + description + '\'' +
                ", productStatus='" + productStatus + '\'' +
                ", stockStatus=" + stockStatus +
                ", categoryName='" + categoryName + '\'' +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
