package com.example.demoa.controller;

import com.example.demoa.entity.user.Cart;
import com.example.demoa.serviceimplementation.CartServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/demoa")
public class CartController {

        private CartServiceImp cartServiceImp;
    @Autowired
    public CartController(CartServiceImp cartServiceImp) {
        this.cartServiceImp = cartServiceImp;
    }

    @PostMapping("/createCartItem")
        public ResponseEntity<String> createItem(@RequestBody Cart cartItem) {
            return new ResponseEntity<>(cartServiceImp.addCartItem(cartItem), HttpStatus.OK);
        }

        @PatchMapping("/updateCartItem/{cartItemId}")
        public ResponseEntity<String> updateItem(@PathVariable("cartItemId") Integer cartItemId, @RequestBody Cart cartItem){
            return new ResponseEntity<>(cartServiceImp.updateCartItem(cartItemId, cartItem), HttpStatus.OK);
        }

        @GetMapping("/readCartItem/{cartItemId}")
        public ResponseEntity<Cart> readItem(@PathVariable("cartItemId") Integer cartItemId){
            return new ResponseEntity<>(cartServiceImp.readCartItem(cartItemId), HttpStatus.OK);
        }

        @GetMapping("/readAllCartItem")
        public List<Cart> readAllItem(){
            return cartServiceImp.readAllCartItem();
        }

        @DeleteMapping("/deleteCartItem/{cartItemId}")
        public ResponseEntity<String> deleteItem(@PathVariable("cartItemId") Integer cartItemId){
            return new ResponseEntity<>(cartServiceImp.deleteCartItem(cartItemId), HttpStatus.OK);
        }

    }

