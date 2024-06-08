package com.learningjava.EcommerceJavaProject.domain.controller;

import com.learningjava.EcommerceJavaProject.api.DTO.collectionsDTO.CartItemDTOadd;
import com.learningjava.EcommerceJavaProject.api.DTO.collectionsDTO.CartItemDTOmodify;
import com.learningjava.EcommerceJavaProject.api.DTO.collectionsDTO.CollectionsDTOmodify;
import com.learningjava.EcommerceJavaProject.domain.repositories.CartItemRepository;
import com.learningjava.EcommerceJavaProject.entity.CartItem;
import com.learningjava.EcommerceJavaProject.entity.Collections;
import com.learningjava.EcommerceJavaProject.exceptions.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartItemController {
    final CartItemRepository cartItemRepository;

    public CartItemController(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @GetMapping
    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    @GetMapping("/{id}")
    public CartItem getCartItemById(@PathVariable Long id) {
        return cartItemRepository.findById(id).get();
    }

    @PostMapping("/add")
    public CartItem saveCartItem(@RequestBody CartItemDTOadd cartItemDTOadd) throws BadRequestException {
        CartItem addToCart = new CartItem();
        addToCart.setQuantity(cartItemDTOadd.getQuantity());
        addToCart.setCollectionsId(cartItemDTOadd.getCollectionsId());
        return cartItemRepository.save(addToCart);
    }

    @PostMapping("/modify/{id}")
    CartItem modifiy(
            @PathVariable Long id,
            @RequestBody CartItemDTOmodify cartItemDTOmodify) throws BadRequestException {
        CartItem cartItemUpdated = cartItemRepository.findById(id).
                orElseThrow(() -> new BadRequestException("Item id " + id +" not found!"));

        cartItemUpdated.setQuantity(cartItemDTOmodify.getQuantity());
        cartItemUpdated.setCollectionsId(cartItemDTOmodify.getCollectionsId());

        return cartItemRepository.save(cartItemUpdated);
    }


    @DeleteMapping
    ResponseEntity<String> deleteItem (@PathVariable Long id) {
        CartItem itemToBeDeleted = cartItemRepository.findById(id).
                orElseThrow(() -> new BadRequestException("Item id " + id +" not found!"));
        cartItemRepository.delete(itemToBeDeleted);
        return ResponseEntity.ok("The item has been deleted.");
    }
}
