package com.example.team11.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Primary Key

    @Column(name = "username",nullable = false, unique = true)
    private String username; // Unique username for login

    @Column(name = "email" ,nullable = false, unique = true)
    private String email; // Unique email

    @Column(name = "password" ,nullable = false)
    private String password; // Password (store hashed values)

    @Enumerated(EnumType.STRING)
    @Column(name = "role" ,nullable = false)
    private Role role; // Role (e.g., CUSTOMER, SUPPLIER, ADMIN)

    @Column(name = "phoneNo")
    private String phoneno; // Phone number

    @Column(name = "company")
    private String company; // Company name (optional)
    
    @Column(name = "address")
    private String address; // Address

    public enum Role {
        CUSTOMER, SUPPLIER, ADMIN
    }

    // Getters////////////////////////////////////////////////////////////
    public int getId() {return id;}

    public String getUsername() {return username;}

    public String getEmail() {return email;}

    public String getPassword() {return password;}

    public Role getRole() {return role;}

    public String getPhoneNo() {return phoneno;}

    public String getCompany() {return company;}

    public String getAddress() {return address;}

    // Setters///////////////////////////////////////////////////////////////

    public void setId(int id) {this.id = id;}

    public void setUsername(String username) {this.username = username;}

    public void setEmail(String email) {this.email = email;}

    public void setPassword(String password) {this.password = password;}

    public void setRole(Role role){this.role = role;}

    public void setPhoneNo(String phoneNo){this.phoneno = phoneNo;}

    public void setCompany(String company){this.company = company;}

    public void setAddress(String address){this.address = address;}

}

