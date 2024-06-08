package com.learningjava.EcommerceJavaProject.api.DTO.collectionsDTO;

public class CartItemDTOadd {
    Long collectionsId;
    int quantity;


    public Long getCollectionsId() {
        return collectionsId;
    }

    public void setCollectionsId(Long collectionsId) {
        this.collectionsId = collectionsId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
