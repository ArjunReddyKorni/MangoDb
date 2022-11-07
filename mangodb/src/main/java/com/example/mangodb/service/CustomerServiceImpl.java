package com.example.mangodb.service;

import com.example.mangodb.domain.Customer;
import com.example.mangodb.exception.CustomerNotFoundException;
import com.example.mangodb.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{


    public CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() throws Exception {
        return customerRepository.findAll();
    }

    @Override
    public boolean deleteCustomer(int customerId) throws CustomerNotFoundException {
        boolean result = false;
        if (customerRepository.findById(customerId).isEmpty()){
            throw new CustomerNotFoundException();
        }else {
            customerRepository.deleteById(customerId);
             result = true;
        }
        return result;
    }

    @Override
    public List<Customer> getAllCustomerByCity(String city) throws CustomerNotFoundException {

       if (customerRepository.findByCustomerFromCity(city).isEmpty()){
           throw new CustomerNotFoundException();
       }
        return customerRepository.findByCustomerFromCity(city);
    }
}
