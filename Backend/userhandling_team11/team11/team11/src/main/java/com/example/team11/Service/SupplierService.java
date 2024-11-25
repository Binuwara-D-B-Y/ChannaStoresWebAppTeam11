package com.example.team11.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.team11.DTO.SupplierDTO;
import com.example.team11.Entity.Supplier;
import com.example.team11.Entity.User;
import com.example.team11.Repository.SupplierRepository;
import com.example.team11.Repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private UserRepository userRepository;

    public Supplier createSupplier(Long userId, SupplierDTO supplierDTO) {
        // Check if the user exists
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User with ID " + userId + " not found"));
        
        // Check if the user is already a supplier
        Optional<Supplier> existingSupplier = supplierRepository.findById(userId);
        if (existingSupplier.isPresent()) {
            throw new RuntimeException("User with ID " + userId + " is already a supplier");
        }
        
        // Map SupplierDTO to Supplier Entity
        Supplier supplier = new Supplier();
        supplier.setUser(user);  // Set the existing user as the supplier's user
        supplier.setCompany(supplierDTO.getCompany());
        supplier.setAddress(supplierDTO.getAddress());
        supplier.setPhoneNumber(supplierDTO.getPhoneNumber());
        
        // Save supplier to the database
        return supplierRepository.save(supplier);
    }

    
    // Find the supplier by ID, throws exception if not found
    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Supplier with ID " + id + " not found"));
    }

    // Return all suppliers
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Transactional
    public Supplier updateSupplier(Long id, SupplierDTO supplierDTO) throws Exception {
        // Fetch supplier by ID
        Supplier supplier = supplierRepository.findById(id)
            .orElseThrow(() -> new Exception("Supplier with ID " + id + " not found"));

        // Update supplier specific fields
        supplier.setCompany(supplierDTO.getCompany());
        supplier.setAddress(supplierDTO.getAddress());
        supplier.setPhoneNumber(supplierDTO.getPhoneNumber());
        supplierRepository.save(supplier);

        // Fetch the related user
        User user = supplier.getUser(); 
        if (user != null) {
            // Update user-related fields 
            user.setEmail(supplierDTO.getEmail());
            user.setPassword(supplierDTO.getPassword());
            user.setUsername(supplierDTO.getUsername());
            userRepository.save(user);
        }

        // Return the updated supplier
        return supplier; 
    }

    public void deleteSupplier(Long id) throws Exception {
        // Validate if supplier exists or not
        Supplier supplierToDelete = supplierRepository.findById(id)
            .orElseThrow(() -> new Exception("Supplier with ID " + id + " not found"));

        // Delete supplier
        supplierRepository.delete(supplierToDelete);
    }
}
