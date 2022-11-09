package com.example.mangodb.service;


import com.example.mangodb.domain.Address;
import com.example.mangodb.domain.Customer;
import com.example.mangodb.exception.CustomerNotFoundException;
import com.example.mangodb.repository.CustomerRepository;
import com.example.mangodb.service.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest1 {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    private Customer cust1,cust2;
    List<Customer> listCustomer;
    Address address1,address2;

    @BeforeEach
    public void setup(){
        address1=new Address("Hyd","CG","India","87978");
        address2=new Address("Indore","MP","India","99978");
        cust1=new Customer(1,"Arjun","s@gmail.com",address1);
        cust2=new Customer(2,"ram","n@gmail.com",address2);

      //   listCustomer = Arrays.asList(cust1,cust2);
       // listCustomer=customerRepository.findAll();

    }
    @Test
    public void savedatacust() throws CustomerNotFoundException {
        when(customerRepository.save(any())).thenReturn(cust1);
        when(customerRepository.findById(cust1.getCustomerId())).thenReturn(Optional.empty());
        assertEquals(cust1,customerService.addCustomer(cust1));
        verify(customerRepository,times(1)).save(any());
        verify(customerRepository,times(1)).findById(any());
    }
}