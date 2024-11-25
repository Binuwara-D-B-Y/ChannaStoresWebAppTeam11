package com.example.team11.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.team11.Entity.User;
import com.example.team11.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    
    public User createUser(User user) {
        return userRepository.save(user);  
    }



    // Find user by email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);  
    }

    public boolean authenticateUser(String email, String password) {
        User user = findByEmail(email);
        if (user == null) {
            return false;  // User not found
        }
        return password.equals(user.getPassword());  // if user found, direct comparison of passwords
    }
}
