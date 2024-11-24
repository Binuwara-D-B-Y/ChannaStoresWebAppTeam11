package com.example.team11.Controller;

import com.example.team11.DTO.UserProfileDTO;
import com.example.team11.Service.UserProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("/{email}")
    public ResponseEntity<UserProfileDTO> getUserProfile(@PathVariable String email) {
        UserProfileDTO userProfileDTO = userProfileService.getUserProfile(email);
        if (userProfileDTO != null) {
            return ResponseEntity.ok(userProfileDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{email}")
    public ResponseEntity<String> updateUserProfile(@PathVariable String email, @RequestBody UserProfileDTO userProfileDTO) {
        boolean updated = userProfileService.updateUserProfile(email, userProfileDTO);
        if (updated) {
            return ResponseEntity.ok("Profile updated successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update-password/{email}")
    public ResponseEntity<String> updatePassword(@PathVariable String email, @RequestParam String currentPassword, @RequestParam String newPassword) {
        boolean updated = userProfileService.updatePassword(email, currentPassword, newPassword);
        if (updated) {
            return ResponseEntity.ok("Password updated successfully!");
        } else {
            return ResponseEntity.status(400).body("Current password is incorrect.");
        }
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<String> deleteUser(@PathVariable String email) {
        boolean deleted = userProfileService.deleteUser(email);
        if (deleted) {
            return ResponseEntity.ok("Account deleted successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

