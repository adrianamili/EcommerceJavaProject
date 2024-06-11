package com.learningjava.EcommerceJavaProject.domain.repositories;

import com.learningjava.EcommerceJavaProject.entity.Collections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CollectionsRepository extends JpaRepository<Collections, Long> {


    List<Collections> findAllProductsByCategoryId(Long categoryId);


    double findByDiscountId(Long id);
}
