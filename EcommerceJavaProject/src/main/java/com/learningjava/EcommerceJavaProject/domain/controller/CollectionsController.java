package com.learningjava.EcommerceJavaProject.domain.controller;

import com.learningjava.EcommerceJavaProject.api.DTO.collectionsDTO.CollectionsDTOadd;
import com.learningjava.EcommerceJavaProject.api.DTO.collectionsDTO.CollectionsDTOmodify;
import com.learningjava.EcommerceJavaProject.domain.repositories.CategoryRepository;
import com.learningjava.EcommerceJavaProject.domain.repositories.SaleRepository;
import com.learningjava.EcommerceJavaProject.entity.Category;
import com.learningjava.EcommerceJavaProject.entity.Collections;
import com.learningjava.EcommerceJavaProject.domain.repositories.CollectionsRepository;
import com.learningjava.EcommerceJavaProject.entity.Sale;
import com.learningjava.EcommerceJavaProject.exceptions.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/collections")
public class CollectionsController {

    //Repository//
    final CollectionsRepository collectionsRepository;
    final CategoryRepository categoryRepository;
//    final SaleRepository saleRepository;


    public CollectionsController(CollectionsRepository collectionsRepository, CategoryRepository categoryRepository) {
        this.collectionsRepository = collectionsRepository;
        this.categoryRepository = categoryRepository;
       
    }

    //Read - GET//
    @GetMapping("/allproducts")
    public List<Collections> getAllProducts() {
        return collectionsRepository.findAll();
    }

    @GetMapping("/allproducts/{id}")
    Collections getById(@PathVariable Long id) {
        return collectionsRepository.findById(id).get();
    }
    

    //Create - POST//
    @PostMapping("/add")

    Collections addProduct(@RequestBody CollectionsDTOadd addDTO) throws BadRequestException {
        Collections productToAdd = new Collections();
        if (addDTO.getName() == null || addDTO.getName().equals(" ")) {
            throw new BadRequestException("Please,enter the product name!");
        }
        productToAdd.setName(addDTO.getName());
        productToAdd.setColor(addDTO.getColor());
        productToAdd.setSize(addDTO.getSize());
        productToAdd.setPriceWithIncludedTaxes(addDTO.getPriceWithIncludedTaxes());
        return collectionsRepository.save(productToAdd);
    }

    //UPDATE//
    @PostMapping("/modify/{id}")
    Collections modifiy(
            @PathVariable Long id,
            @RequestBody CollectionsDTOmodify modifyDTO) throws BadRequestException {
        Collections productModified = collectionsRepository.findById(id).
                orElseThrow(() -> new BadRequestException("Product id " + id +" not found!"));

        productModified.setName(modifyDTO.getName());
        productModified.setColor(modifyDTO.getColor());
        productModified.setSize(modifyDTO.getSize());
        productModified.setPriceWithIncludedTaxes(modifyDTO.getPriceWithIncludedTaxes());

        return collectionsRepository.save(productModified);
    }

    //DELETE//
    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteProduct (@PathVariable Long id) {
        Collections productToBeDeleted = collectionsRepository.findById(id).
                orElseThrow(() -> new BadRequestException("Product id " + id +" not found!"));
        collectionsRepository.delete(productToBeDeleted);
        return ResponseEntity.ok("The product has been deleted.");
    }

    //READ - Category//
    @GetMapping("/category/{categoryId}")
    List<Collections>getAllProductsByCategoryId(
        @PathVariable Long categoryId){
        return collectionsRepository.findAllProductsByCategoryId(categoryId);
    }

//    CREATE - Discount/Sale
    @PostMapping("/checkout/discount/{id}*")
    Collections discount(@PathVariable Long id,
                     @RequestParam String discountCode) {
        Collections productDiscount = collectionsRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Product id " + id +" not found!"));

        double discountPercentage = 0;
        if (discountCode == null ) {
            discountPercentage = 1;
        } else {
            discountPercentage = collectionsRepository.findByDiscountId(id);
        }
        productDiscount.setPriceWithIncludedTaxes((productDiscount.getPriceWithIncludedTaxes() * discountPercentage));

        return productDiscount;

    }



    @GetMapping("/test")
    public String test(){
        return "test";
    }


}
