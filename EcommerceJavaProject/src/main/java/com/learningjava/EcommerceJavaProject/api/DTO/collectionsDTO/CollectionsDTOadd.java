package com.learningjava.EcommerceJavaProject.api.DTO.collectionsDTO;

public class CollectionsDTOadd {
    String name;
    String color;
    String size;
    double priceWithIncludedTaxes;
    Integer categoryId;
    Integer discountId;

    public CollectionsDTOadd(String name, String color, String size, double priceWithIncludedTaxes, Integer categoryId, Integer discountId) {
        this.name = name;
        this.color = color;
        this.size = size;
        this.priceWithIncludedTaxes = priceWithIncludedTaxes;
        this.categoryId = categoryId;
        this.discountId = discountId;
    }

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }



    public double getPriceWithIncludedTaxes() {
        return priceWithIncludedTaxes;
    }

    public void setPriceWithIncludedTaxes(double priceWithIncludedTaxes) {
        this.priceWithIncludedTaxes = priceWithIncludedTaxes;
    }
}
