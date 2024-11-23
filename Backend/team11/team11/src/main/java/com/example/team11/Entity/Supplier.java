package com.example.team11.Entity;


import jakarta.persistence.*;
@Entity
@Table(name = "Supplier")
public class Supplier {
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private int id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "phoneNo", nullable = false)
    private String phoneNo;

    @Column(name = "company", nullable = false)
    private String company;

    @Column(name = "address", nullable = false)
    private String address;

    // Getters////////////////////////////////////////////////////////////
    public int getId() {return id;}

    public String getUsername() {return username;}

    public String getEmail() {return email;}

    public String getPassword() {return password;}

    public String getRole() {return role;}

    public String getPhoneNo() {return phoneNo;}

    public String getCompany() {return company;}

    public String getAddress() {return address;}

    // Setters///////////////////////////////////////////////////////////////

    public void setId(int id) {this.id = id;}

    public void setUsername(String username) {this.username = username;}

    public void setEmail(String email) {this.email = email;}

    public void setPassword(String password) {this.password = password;}

    public void setRole(String role){this.role = role;}

    public void setPhoneNo(String phoneNo){this.phoneNo = phoneNo;}

    public void setCompany(String company){this.company = company;}

    public void setAddress(String address){this.address = address;}
}
