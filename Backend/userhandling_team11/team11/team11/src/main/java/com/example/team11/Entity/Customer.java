package com.example.team11.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    private Long id;

    @OneToOne(cascade = CascadeType.ALL) // to auto update 
    @MapsId
    @JoinColumn(name = "id") // foreign to users.id
    private User user;

    @Column(name = "phone_number", nullable = true)
    private String phoneNumber;

    
    // Getters  

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }



  //Setters

    public void setId(Long id) {
    this.id = id;
    }

    public void setUser(User user) {
    this.user = user;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}