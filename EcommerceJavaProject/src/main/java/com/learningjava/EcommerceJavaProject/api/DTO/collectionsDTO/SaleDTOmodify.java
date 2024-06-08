package com.learningjava.EcommerceJavaProject.api.DTO.collectionsDTO;

public class SaleDTOmodify {
    
    double discountPercentage;
    String discountCode;
    

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }
}
