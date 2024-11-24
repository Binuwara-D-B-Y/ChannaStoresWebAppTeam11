package com.example.team11.Service;

import com.example.team11.DTO.UserDTO;
import com.example.team11.Entity.User;
import com.example.team11.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO getUserProfile(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            UserDTO userProfileDTO = new UserDTO();
            userProfileDTO.setUserName(user.getUserName());
            userProfileDTO.setEmail(user.getEmail());
            userProfileDTO.setPassword(user.getPassword());
            //userProfileDTO.setPhoneNo(user.getPhoneNo());
            return userProfileDTO;
        }
        return null;
    }

    public boolean updateUserProfile(String email, UserDTO userProfileDTO) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setUserName(userProfileDTO.getUserName());
            user.setPassword(userProfileDTO.getPassword());
            //user.setPhoneNo(userProfileDTO.getPhoneNo());
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
