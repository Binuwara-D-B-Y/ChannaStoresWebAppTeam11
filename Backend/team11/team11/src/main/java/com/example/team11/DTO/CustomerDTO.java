package com.example.team11.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CustomerDTO {

    private int id;

    @NotBlank(message = "Username cannot be empty")
    private String username;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    private String role;
    private Integer phoneNo;

    // Getters////////////////////////////////////////////////////////////
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