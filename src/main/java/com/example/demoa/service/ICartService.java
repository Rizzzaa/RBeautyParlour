package com.example.demoa.service;

import com.example.demoa.entity.user.Cart;

import java.util.List;

public interface ICartService {
    String addCartItem(Cart cartItem);
    String updateCartItem(Integer id, Cart cartItem);
    String deleteCartItem(Integer id);
    Cart readCartItem(Integer id);
    List<Cart> readAllCartItem();
}
