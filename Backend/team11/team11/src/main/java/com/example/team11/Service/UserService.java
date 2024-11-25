package com.example.team11.Service;

import com.example.team11.Entity.User;
import com.example.team11.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean authenticateUser(String email, String password) {
        User user = findByEmail(email);
        if (user == null) {
            return false;  // user deosnt exist
        }
        return password.equals(user.getPassword());  // validate passwords
    }
}
