package com.example.team11.Service;

import com.example.team11.DTO.UserProfileDTO;
import com.example.team11.Entity.User;
import com.example.team11.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileService {

    @Autowired
    private UserRepository userRepository;

    public UserProfileDTO getUserProfile(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            UserProfileDTO userProfileDTO = new UserProfileDTO();
            userProfileDTO.setName(user.getName());
            userProfileDTO.setEmail(user.getEmail());
            userProfileDTO.setPhone(user.getPhone());
            return userProfileDTO;
        }
        return null;
    }

    public boolean updateUserProfile(String email, UserProfileDTO userProfileDTO) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setName(userProfileDTO.getName());
            user.setPhone(userProfileDTO.getPhone());
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public boolean updatePassword(String email, String currentPassword, String newPassword) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(currentPassword)) {
                user.setPassword(newPassword);
                userRepository.save(user);
                return true;
            }
        }
        return false;
    }

    public boolean deleteUser(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            userRepository.delete(userOptional.get());
            return true;
        }
        return false;
    }
}
