package com.example.team11.Controller;
import com.example.team11.DTO.SupplierDTO;
import com.example.team11.Service.SupplierService;

import com.example.team11.Entity.Supplier;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @PostMapping("/create")
    public ResponseEntity<String> createSupplier(@RequestBody SupplierDTO supplierDTO) {
        supplierService.saveSupplier(supplierDTO);
        return ResponseEntity.ok("Supplier Account created successfully");
    }

    // Retrieve Supplier by ID
    @GetMapping("/getById/{id}")
    public ResponseEntity<SupplierDTO> getSupplierById(@PathVariable int id) {
        SupplierDTO supplierDTO = supplierService.getSupplierById(id);
        if (supplierDTO != null) {
            return ResponseEntity.ok(supplierDTO);
        }
        return ResponseEntity.notFound().build();
    }

    // Retrieve Supplier by Email
    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<SupplierDTO> getSupplierByEmail(@PathVariable String email) {
        SupplierDTO supplierDTO = supplierService.getSupplierByEmail(email);
        if (supplierDTO != null) {
            return ResponseEntity.ok(supplierDTO);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete Supplier by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable int id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.ok("Supplier deleted successfully");
    }

    // Update Supplier
    /*
    @PutMapping("/update")
    public ResponseEntity<String> updateSupplier(@RequestBody SupplierDTO supplierDTO) {
        supplierService.updateSupplier(supplierDTO);
        return ResponseEntity.ok("Supplier updated successfully");
    }*/
    @PutMapping("/update")
    public ResponseEntity<String> updateSupplier(@RequestBody SupplierDTO supplierDTO) {
    try {
        Supplier updatedSupplier = supplierService.updateSupplier(supplierDTO);
        return ResponseEntity.ok("Supplier updated successfully: " + updatedSupplier);
    } catch (RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}


}
