package com.learningjava.EcommerceJavaProject.domain.repositories;

import com.learningjava.EcommerceJavaProject.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
}
