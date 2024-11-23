package com.example.team11.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.team11.DTO.SupplierDTO;
import com.example.team11.Entity.Supplier;
import com.example.team11.Repository.SupplierRepository;

import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public void saveSupplier(SupplierDTO supplierDTO) {
        Supplier supplier = new Supplier();
        supplier.setUsername(supplierDTO.getUsername());
        supplier.setEmail(supplierDTO.getEmail());
        supplier.setPassword(supplierDTO.getPassword());
        supplier.setRole(supplierDTO.getRole());
        supplier.setPhoneNo(supplierDTO.getPhoneNo());
        supplier.setCompany(supplierDTO.getCompany());
        supplier.setAddress(supplierDTO.getAddress());

        supplierRepository.save(supplier);
    }

    public void deleteSupplier(SupplierDTO supplierDTO){

    }

    public void updateSupplier01(SupplierDTO supplierDTO){

    }

    public void searchSupplier(SupplierDTO supplierDTO){

    }

    public SupplierDTO getSupplierById(int id) {
        Optional<Supplier> supplier = supplierRepository.findById(id);
        if (supplier.isPresent()) {
            Supplier s = supplier.get();
            SupplierDTO dto = new SupplierDTO();
            dto.setId(s.getId());
            dto.setUsername(s.getUsername());
            dto.setEmail(s.getEmail());
            dto.setPassword(s.getPassword());
            dto.setRole(s.getRole());
            dto.setPhoneNo(s.getPhoneNo());
            dto.setCompany(s.getCompany());
            dto.setAddress(s.getAddress());
            return dto;
        }
        return null; // Or throw an exception
    }

    // [NEW] Retrieve Supplier by Email
    public SupplierDTO getSupplierByEmail(String email) {
        Supplier supplier = supplierRepository.findByEmail(email);
        if (supplier != null) {
            SupplierDTO dto = new SupplierDTO();
            dto.setId(supplier.getId());
            dto.setUsername(supplier.getUsername());
            dto.setEmail(supplier.getEmail());
            dto.setPassword(supplier.getPassword());
            dto.setRole(supplier.getRole());
            dto.setPhoneNo(supplier.getPhoneNo());
            dto.setCompany(supplier.getCompany());
            dto.setAddress(supplier.getAddress());
            return dto;
        }
        return null; // Or throw an exception
    }

    // [NEW] Delete Supplier by ID
    public void deleteSupplier(int id) {
        supplierRepository.deleteById(id);
    }

    // [NEW] Update Supplier
    public Supplier updateSupplier(SupplierDTO supplierDTO) {
        Optional<Supplier> existingSupplier = supplierRepository.findById(supplierDTO.getId());
        if (existingSupplier.isPresent()) {
            Supplier supplier = existingSupplier.get();
            
            // Update fields
            supplier.setUsername(supplierDTO.getUsername());
            supplier.setEmail(supplierDTO.getEmail());
            supplier.setPassword(supplierDTO.getPassword());
            supplier.setRole(supplierDTO.getRole());
            supplier.setPhoneNo(supplierDTO.getPhoneNo());
            supplier.setCompany(supplierDTO.getCompany());
            supplier.setAddress(supplierDTO.getAddress());
            
            // Save updated supplier
            return supplierRepository.save(supplier);
        } else {
            // Throw an exception or handle the case when supplier doesn't exist
            throw new RuntimeException("Supplier with ID " + supplierDTO.getId() + " not found.");
        }
    }
 
}