
package com.example.team11.Service;

import com.example.team11.DTO.CartItemDTO;
import com.example.team11.Entity.Cart;
import com.example.team11.Entity.CartItem;
import com.example.team11.Entity.Product;
import com.example.team11.Repository.CartItemRepository;
import com.example.team11.Repository.CartRepository;
import com.example.team11.Repository.ProductRepository;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class CartItemService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository; // Add ProductRepository field

    // Constructor injection for all repositories
    public CartItemService(CartRepository cartRepository, CartItemRepository cartItemRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository; // Initialize the ProductRepository
    }

    @Transactional
public void addCartItem(Long cartId, CartItemDTO cartItemDTO) {
    // Step 1: Retrieve the Cart by ID
    Cart cart = cartRepository.findById(cartId)
            .orElseThrow(() -> new RuntimeException("Cart not found"));

    // Step 2: Retrieve the Product by productId from the DTO
    Product product = productRepository.findById(cartItemDTO.getProductId())
            .orElseThrow(() -> new RuntimeException("Product not found"));

    // Step 3: Create and populate the CartItem entity
    CartItem cartItem = new CartItem();
    cartItem.setProduct(product);  // Associate the CartItem with the Product
    cartItem.setProductName(cartItemDTO.getProductName());
    cartItem.setQuantity(cartItemDTO.getQuantity());
    cartItem.setPrice(cartItemDTO.getPrice());
    cartItem.setCart(cart);  // Associate with the Cart

    // Step 4: Save the CartItem entity
    cartItemRepository.save(cartItem);

    // Step 5: Add the CartItem to the Cart's items list
    cart.getItems().add(cartItem);

    // Step 6: Update the Cart's total price
    updateTotalPrice(cart);

    // Step 7: Save the updated Cart entity
    cartRepository.save(cart);
}


    
/*
    // Update a CartItem
    public void updateCartItem(Long cartId, Long itemId, CartItemDTO cartItemDTO) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        CartItem cartItem = cart.getItems().stream()
                .filter(item -> item.getId().equals(itemId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("CartItem not found"));
        cartItem.setProductName(cartItemDTO.getProductName());
        cartItem.setQuantity(cartItemDTO.getQuantity());
        cartItem.setPrice(cartItemDTO.getPrice());

        // Update total price
        updateTotalPrice(cart);

        // Save the updated cart
        cartRepository.save(cart);
    }
*/
    // Delete a CartItem
    public void deleteCartItem(Long cartId, Long itemId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        cart.getItems().removeIf(item -> item.getId().equals(itemId)); // Remove item by ID
        
        // Update total price
        updateTotalPrice(cart);

        // Save the updated cart
        cartRepository.save(cart);
    }

    // Helper method to update the total price of the cart
    private void updateTotalPrice(Cart cart) {
        double totalPrice = 0;
        for (CartItem item : cart.getItems()) {
            totalPrice += item.getPrice() * item.getQuantity();
        }
        cart.setTotalPrice(totalPrice);
    }

    public void updateCartItemQuantity(Long cartId, Long itemId, int newQuantity) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        CartItem cartItem = cart.getItems().stream()
                .filter(item -> item.getId().equals(itemId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("CartItem not found"));
    
        cartItem.setQuantity(newQuantity);
    
        // Update total price of the cart
        updateTotalPrice(cart);
    
        // Save the updated cart
        cartRepository.save(cart);
    }
    

}
