package com.learningjava.EcommerceJavaProject.domain.repositories;

import com.learningjava.EcommerceJavaProject.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SaleRepository extends JpaRepository<Sale,Long> {

    @Query("""
            SELECT s FROM Sale s WHERE s.discountCode = :discountCode
            """)
    Sale findDiscountPercentageByDiscountCode(String discountCode);
}
