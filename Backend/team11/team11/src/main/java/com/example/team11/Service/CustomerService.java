package com.example.team11.Service;

import com.example.team11.DTO.CustomerDTO;
import com.example.team11.Entity.Customer;
import com.example.team11.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unused")
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setUsername(customerDTO.getUsername());
        customer.setEmail(customerDTO.getEmail());
        customer.setPassword(customerDTO.getPassword());
        customer.setRole(customerDTO.getRole());
        customer.setPhoneNo(customerDTO.getPhoneNo());
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(int id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer with ID " + id + " not found"));
    }

    public Customer updateCustomer(int id, CustomerDTO customerDTO) {
        Customer customer = getCustomerById(id);
        customer.setUsername(customerDTO.getUsername());
      //  customer.setEmail(customerDTO.getEmail());
        customer.setPassword(customerDTO.getPassword());
      //  customer.setRole(customerDTO.getRole());
        customer.setPhoneNo(customerDTO.getPhoneNo());
        return customerRepository.save(customer);
    }

    public void deleteCustomer(int id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer with ID " + id + " not found");
        }
        customerRepository.deleteById(id);
    }
}
