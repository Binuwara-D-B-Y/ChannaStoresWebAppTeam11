package com.example.team11.Service;

import com.example.team11.DTO.CustomerDTO;
import com.example.team11.Entity.Customer;
import com.example.team11.Entity.User;
import com.example.team11.Repository.CustomerRepository;
import com.example.team11.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;

    public Customer createCustomer(Long userId, CustomerDTO customerDTO) {
        // checking if user exists
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User with ID " + userId + " not found"));
        
        // check if user is already a customer
        Optional<Customer> existingCustomer = customerRepository.findById(userId);
        if (existingCustomer.isPresent()) {
            throw new RuntimeException("User with ID " + userId + " is already a customer");
        }
        
        Customer customer = new Customer();
        customer.setUser(user);
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(Long id) throws Exception {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isEmpty()) 
            {
            throw new Exception("Customer with ID " + id + " not found");
            }
        return customerOptional.get();
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Transactional
    public Customer updateCustomer(Long id, CustomerDTO customerDTO) throws Exception {
        // retrive customer by id
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new Exception("Customer not found"));
        
        if (customerDTO.getPhoneNumber() != null) {
            customer.setPhoneNumber(customerDTO.getPhoneNumber()); // Update customer details
        }
        
        customerRepository.save(customer);

        // retrive the user related to customer
        User user = customer.getUser();
        if (user != null) {
            // Update user fields
            if (customerDTO.getEmail() != null) {
                user.setEmail(customerDTO.getEmail());
            }
            if (customerDTO.getUsername() != null) {
                user.setUsername(customerDTO.getUsername());
            }
            if (customerDTO.getPassword() != null) {
                user.setPassword(customerDTO.getPassword());
            }
            
            userRepository.save(user);
        }
        return customer;
    }

    public void deleteCustomer(Long id) throws Exception {
        Customer customerToDelete = getCustomerById(id);

        customerRepository.delete(customerToDelete);
    } 
}
