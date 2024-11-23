package com.example.team11.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.team11.Entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    Supplier findByEmail(String email);
}
