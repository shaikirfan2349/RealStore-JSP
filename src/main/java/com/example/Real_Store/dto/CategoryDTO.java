package com.example.Real_Store.dto;

public class CategoryDTO {
    private Long categoryId;
//    @NotBlank(message = "{categoryName.Blank}")
    private String name;
//    @NotBlank(message = "{description.Blank}")
    private String description;

//    public List<Product> productDTOList;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public List<Product> getProductDTOList() {
//        return productDTOList;
//    }
//
//    public void setProductDTOList(List<Product> productDTOList) {
//        this.productDTOList = productDTOList;
//    }
}
