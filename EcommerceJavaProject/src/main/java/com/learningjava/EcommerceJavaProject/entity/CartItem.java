package com.learningjava.EcommerceJavaProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long collectionsId;
    int quantity;

    public CartItem(Long id, Long collectionsId, int quantity) {
        this.id = id;
        this.collectionsId = collectionsId;
        this.quantity = quantity;
    }

    public CartItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
