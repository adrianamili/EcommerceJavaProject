package com.learningjava.EcommerceJavaProject.domain.controller;

import com.learningjava.EcommerceJavaProject.api.DTO.collectionsDTO.CollectionsDTOmodify;
import com.learningjava.EcommerceJavaProject.api.DTO.collectionsDTO.SaleDTOadd;
import com.learningjava.EcommerceJavaProject.api.DTO.collectionsDTO.SaleDTOmodify;
import com.learningjava.EcommerceJavaProject.domain.repositories.SaleRepository;
import com.learningjava.EcommerceJavaProject.entity.Collections;
import com.learningjava.EcommerceJavaProject.entity.Sale;
import com.learningjava.EcommerceJavaProject.exceptions.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sale")
public class SaleController {
    
    final SaleRepository saleRepository;

    public SaleController(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }
    //CREATE
    @PostMapping("/add")
    public Sale addDiscount(@RequestBody SaleDTOadd saleDTOadd){
        Sale discountAdded = new Sale();
        discountAdded.setDiscountCode(saleDTOadd.getDiscountCode());
        discountAdded.setDiscountPercentage(saleDTOadd.getDiscountPercentage());
        return saleRepository.save(discountAdded);
    }
    
    //READ
    @GetMapping("discount/{id}")
    Sale getById(@PathVariable Long id){
        return saleRepository.findById(id).get();
    }
    
    //UPDATE
    @PostMapping("/modify/{id}")
    Sale updateDiscount(
            @PathVariable Long id,
            @RequestBody SaleDTOmodify modifyDTO) throws BadRequestException {
        Sale discountModified = saleRepository.findById(id).
                orElseThrow(() -> new BadRequestException("Discount id " + id + " not found!"));

        discountModified.setDiscountCode(modifyDTO.getDiscountCode());
        discountModified.setDiscountPercentage(modifyDTO.getDiscountPercentage());

        return saleRepository.save(discountModified);
    }
    
    //DELETE
    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteDiscount (@PathVariable Long id) {
        Sale discountToBeDeleted = saleRepository.findById(id).
                orElseThrow(() -> new BadRequestException("Discount id " + id +" not found!"));
        saleRepository.delete(discountToBeDeleted);
        return ResponseEntity.ok("Discount deleted successfully!");
    }
    
}
