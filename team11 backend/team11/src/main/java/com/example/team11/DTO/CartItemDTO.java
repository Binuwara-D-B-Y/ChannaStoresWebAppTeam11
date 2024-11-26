package com.example.team11.DTO;

public class CartItemDTO {
    private Long id;
    private String productName;
    private Integer quantity;
    private Double price;

    public CartItemDTO(Long id, String productName, Integer quantity, Double price) {

        this.id = id;

        this.productName = productName;

        this.quantity = quantity;

        this.price = price;

    }
    public CartItemDTO() {

    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}