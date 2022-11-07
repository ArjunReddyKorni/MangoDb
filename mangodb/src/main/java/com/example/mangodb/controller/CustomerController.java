package com.example.mangodb.controller;

import com.example.mangodb.domain.Customer;
import com.example.mangodb.exception.CustomerNotFoundException;
import com.example.mangodb.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer/api/")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "customer")
    public ResponseEntity<?> insertCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping(value = "customers")
    public ResponseEntity<?> fetchCustomer() throws Exception {
            
        ResponseEntity<?> responseEntity = null;
        try {
           responseEntity = new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
        }catch (Exception e){
            System.out.println("e = " + e);
        }
        return responseEntity; 
    }

    @DeleteMapping("customer/{customerId}")
    public ResponseEntity<?> deleteByCustomerId(@PathVariable int customerId) throws CustomerNotFoundException {

        ResponseEntity<?> responseEntity = null;
        try{
           responseEntity =  new ResponseEntity<>(customerService.deleteCustomer(customerId),HttpStatus.OK);
        }catch (Exception e){
            throw new CustomerNotFoundException();
        }
        return responseEntity;

    }

    @GetMapping("customers/{city}")
    public ResponseEntity<?> getAllCustomersFromCity(@PathVariable String city){
        ResponseEntity<?> responseEntity = null;
        try{
            responseEntity = new ResponseEntity<>(customerService.getAllCustomerByCity(city),HttpStatus.FOUND);
        }catch (Exception e){
            System.out.println("e = " + e);
        }
        return responseEntity;
    }
}
