package com.example.team11.Controller;

import com.example.team11.DTO.AdminDTO;
import com.example.team11.Entity.Admin;
import com.example.team11.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // get all admins
    @GetMapping
    public List<AdminDTO> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    // get admin by ID
    @GetMapping("/{id}")
    public AdminDTO getAdminById(@PathVariable Long id) {
        return adminService.getAdminById(id);
    }

    // Create a new admin by linking an existing user
    @PostMapping("/{userId}")
    public Admin createAdmin(@PathVariable Long userId) {
        return adminService.createAdmin(userId);
    }

    // delete admin by ID
    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
    }
}
