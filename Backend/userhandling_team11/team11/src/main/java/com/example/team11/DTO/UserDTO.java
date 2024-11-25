package com.example.team11.DTO;

public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String role;

    // Getters  
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    
    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }


    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
