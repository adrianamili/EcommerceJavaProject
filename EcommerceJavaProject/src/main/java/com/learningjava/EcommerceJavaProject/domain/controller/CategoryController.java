package com.learningjava.EcommerceJavaProject.domain.controller;

import com.learningjava.EcommerceJavaProject.api.DTO.collectionsDTO.CategoryDTOadd;
import com.learningjava.EcommerceJavaProject.api.DTO.collectionsDTO.CategoryDTOmodify;
import com.learningjava.EcommerceJavaProject.api.DTO.collectionsDTO.CollectionsDTOmodify;
import com.learningjava.EcommerceJavaProject.domain.repositories.CategoryRepository;
import com.learningjava.EcommerceJavaProject.entity.Category;
import com.learningjava.EcommerceJavaProject.entity.Collections;
import com.learningjava.EcommerceJavaProject.exceptions.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    //CREATE - Category//
    @PostMapping("/add")
    Category addCategory(@RequestBody CategoryDTOadd categoryDTOadd){
        Category categoryAdded = new Category();
        categoryAdded.setId(categoryDTOadd.getId());
        categoryAdded.setName(categoryDTOadd.getName());

        return categoryRepository.save(categoryAdded);
    }

    //READ//
    @GetMapping("/menu")
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }


    //UPDATE - to change the name of existing category id
    // ex: SpringCollection 2023->SpringCollection 2024

    @PostMapping("/modify/{id}")
    Category modifiy(
            @PathVariable Long id,
            @RequestBody CategoryDTOmodify modifyDTO) throws BadRequestException {
        Category categoryUpdated = categoryRepository.findById(id).
                orElseThrow(() -> new BadRequestException("Category id " + id +" not found!"));

        categoryUpdated.setName(modifyDTO.getName());

        return categoryRepository.save(categoryUpdated);
    }

    //DELETE//
    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteCategory (@PathVariable Long id) {
        Category categoryToBeDeleted = categoryRepository.findById(id).
                orElseThrow(() -> new BadRequestException("Category id " + id +" not found!"));
        categoryRepository.delete(categoryToBeDeleted);
        return ResponseEntity.ok("The category has been deleted.");
    }


}
