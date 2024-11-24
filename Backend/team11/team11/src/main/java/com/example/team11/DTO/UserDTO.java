package com.example.team11.DTO;

public class UserDTO {
    private int id;
    private String username;
    private String email;
    private String password;
    private String role;
    //private int PhoneNo;


    // Getters and Setters

    public int getid(){
        return id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole(){
        return role;
    }

    public void setRole(String role){
        this.role = role;
    }

    /*public int getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(int PhoneNo) {
        this.PhoneNo = PhoneNo;
    } */
}
