package com.example.demoa.serviceimplementation;

import com.example.demoa.entity.user.Cart;
import com.example.demoa.exception.CartItemNotFoundException;
import com.example.demoa.exception.InvalidArgumentException;
import com.example.demoa.repository.CartRepository;
import com.example.demoa.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImp implements ICartService {
    private CartRepository cartRepository;

    @Autowired
    public CartServiceImp(CartRepository cartRepository){
        this.cartRepository=cartRepository;
    }

    @Override
    public String addCartItem(Cart cartItem) {
        if(cartItem != null){
        cartRepository.save(cartItem);
        return "Item Added";
        }else {
            throw new InvalidArgumentException();
        }
    }

    @Override
    public String updateCartItem(Integer id, Cart cartItem) {
        if(cartItem != null){
        Cart cartOfId = cartRepository.findById(id).orElseThrow(CartItemNotFoundException::new);
        if(cartItem.getItemName() != null){
            cartOfId.setItemName(cartItem.getItemName());
        }
        if(cartItem.getCategory() != null){
            cartOfId.setCategory(cartItem.getCategory());
        }
        if(cartItem.getCompany() != null){
            cartOfId.setCompany(cartItem.getCompany());
        }
        if(cartItem.getItemCost() != null){
            cartOfId.setItemCost(cartItem.getItemCost());
        }
        cartRepository.save(cartOfId);
        return "Item Updated";
        }else {
            throw new InvalidArgumentException();
        }
    }

    @Override
    public String deleteCartItem(Integer id) {
        cartRepository.findById(id).orElseThrow(CartItemNotFoundException::new);
        cartRepository.deleteById(id);
        return "Item Deleted";
    }


    @Override
    public Cart readCartItem(Integer id) {
        return cartRepository.findById(id).orElseThrow(CartItemNotFoundException::new);
    }

    @Override
    public List<Cart> readAllCartItem() {
        return new ArrayList<>(cartRepository.findAll());
    }
}
