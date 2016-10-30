package com.droidconuk.frasam.preparemyorders.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by francescoditrani on 30/10/16.
 */

public class Cart {

    Map<String, Integer> cartItems;

    public Cart(Map<String, Integer> cartItems) {
        this.cartItems = cartItems;
    }

    public Cart() {
        cartItems = new HashMap<String, Integer>();
    }

    public Map<String, Integer> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<String, Integer> cartItems) {
        this.cartItems = cartItems;
    }

    public void addItemToCart(String productCode){
        Integer numberOfProducts = null;
        if (cartItems != null)   numberOfProducts = cartItems.get(productCode);
        if (numberOfProducts != null){
            cartItems.put(productCode, numberOfProducts+1);
        } else {
            cartItems.put(productCode, 1);
        }
    }
}
