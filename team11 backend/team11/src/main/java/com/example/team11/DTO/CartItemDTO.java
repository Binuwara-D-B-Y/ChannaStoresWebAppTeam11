package com.example.team11.DTO;

public class CartItemDTO {
    private Long productId;
    private String productName;
    private int quantity;
    private double price;

    // Getters and setters
    //public Long getId() { return id; }
    //public void setId(Long id) { this.id = id; }

    public Long getProductId() { 
        return productId; 
    }

    public void setProductId(Long productId) { 
        this.productId = productId; 
    }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}