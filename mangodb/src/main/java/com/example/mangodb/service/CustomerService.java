package com.example.mangodb.service;

import com.example.mangodb.domain.Customer;
import com.example.mangodb.exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {

    Customer addCustomer(Customer customer);
    List<Customer>  getAllCustomers() throws Exception;
    boolean deleteCustomer(int customerId) throws CustomerNotFoundException;
    List<Customer> getAllCustomerByCity(String city) throws  CustomerNotFoundException;

}
