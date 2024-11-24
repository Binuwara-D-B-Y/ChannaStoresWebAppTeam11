package com.example.team11.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@SuppressWarnings("unused")
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", columnDefinition = "VARCHAR(15) DEFAULT 'Customer'")
    private String role;

    @Column(name = "phone_no", nullable = true)
    private Integer phoneNo;

    /////Getters////////////////////////////////////////////////////
    public int getId() {return id;}

    public String getUsername() {return username;}

    public String getEmail() {return email;}

    public String getPassword() {return password;}

    public String getRole() {return role;}

    public int getPhoneNo() {return phoneNo;}

    // Setters///////////////////////////////////////////////////////////////

    public void setId(int id) {this.id = id;}

    public void setUsername(String username) {this.username = username;}

    public void setEmail(String email) {this.email = email;}

    public void setPassword(String password) {this.password = password;}

    public void setRole(String role){this.role = role;}

    public void setPhoneNo(int phoneNo){this.phoneNo = phoneNo;}
}
