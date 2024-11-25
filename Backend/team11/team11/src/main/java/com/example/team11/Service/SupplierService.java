package com.example.team11.Service;

import com.example.team11.DTO.SupplierDTO;
import com.example.team11.Entity.Supplier;
import com.example.team11.Entity.User;
import com.example.team11.Repository.SupplierRepository;
import com.example.team11.Repository.UserRepository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private UserRepository userRepository;

    public Supplier createSupplier(Long userId, SupplierDTO supplierDTO) {
        // check supplier exists
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User with ID " + userId + " not found"));
        
        // check if user is already a supplier
        Optional<Supplier> existingSupplier = supplierRepository.findById(userId);
        if (existingSupplier.isPresent()) {
            throw new RuntimeException("User with ID " + userId + " is already a supplier");
        }
        
        // map SupplierDTO to Supplier Entity
        Supplier supplier = new Supplier();
        supplier.setUser(user);
        supplier.setCompany(supplierDTO.getCompany());
        supplier.setAddress(supplierDTO.getAddress());
        supplier.setPhoneNumber(supplierDTO.getPhoneNumber());
        
        return supplierRepository.save(supplier);
    }

    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Supplier with ID " + id + " not found"));
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Transactional
    public Supplier updateSupplier(Long id, SupplierDTO supplierDTO) throws Exception {
        // get supplier by ID
        Supplier supplier = supplierRepository.findById(id)
            .orElseThrow(() -> new Exception("Supplier with ID " + id + " not found"));

        // update supplier details
        supplier.setCompany(supplierDTO.getCompany());
        supplier.setAddress(supplierDTO.getAddress());
        supplier.setPhoneNumber(supplierDTO.getPhoneNumber());
        supplierRepository.save(supplier);

        // // retrive the user related to customer
        User user = supplier.getUser();
        if (user != null) {
            // Update user fields
            user.setEmail(supplierDTO.getEmail());
            user.setPassword(supplierDTO.getPassword());
            user.setUsername(supplierDTO.getUsername());
            userRepository.save(user);
        }
        return supplier;
    }

    public void deleteSupplier(Long id) throws Exception {
        // check if supplier exists
        Supplier supplierToDelete = supplierRepository.findById(id)
            .orElseThrow(() -> new Exception("Supplier with ID " + id + " not found"));
        supplierRepository.delete(supplierToDelete);
    }
}
