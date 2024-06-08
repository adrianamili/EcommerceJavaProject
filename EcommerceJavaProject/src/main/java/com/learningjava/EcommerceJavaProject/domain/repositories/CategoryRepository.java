package com.learningjava.EcommerceJavaProject.domain.repositories;

import com.learningjava.EcommerceJavaProject.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.function.Supplier;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
