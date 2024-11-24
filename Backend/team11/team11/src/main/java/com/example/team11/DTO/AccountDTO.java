package com.example.team11.DTO;

public class AccountDTO {
    private int id;
    private String username;
    private String email;
    private String password;
    private String role;
    private String phoneNo;
    private String company;
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

