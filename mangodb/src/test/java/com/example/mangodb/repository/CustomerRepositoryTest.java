package com.example.mangodb.repository;

import com.example.mangodb.domain.Address;
import com.example.mangodb.domain.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;
    private Address address;
    private Customer customer;

    @BeforeEach
    public void setUp(){
        address = new Address("Mumbai","MH","india","50634");
        customer = new Customer(15,"Arjun","Arjun@123",address);
    }

//    @AfterEach
//    public void tearDown(){
//        address = null;
//        customer = null;
//        customerRepository.deleteAll();
//    }

    @Test
    public void saveCustomer() {
        customerRepository.save(customer);
        Customer customer1 = customerRepository.findById(customer.getCustomerId()).get();
        assertNotNull(customer1);
        assertEquals(customer.getCustomerId(),customer1.getCustomerId());
    }

    @Test
    public void fetchAllCustomer(){

        address = new Address("hyderabad","Ts","india","50634");
        customer = new Customer(5,"Arjun","Arjun@123",address);
       // customerRepository.insert(customer);
        List<Customer> list = customerRepository.findAll();
        assertEquals(7,list.size());
        assertNotEquals(5,list.size());
        assertEquals("Arjun",list.get(1).getCustomerName());
    }

    @Test
    public void deleteCustomer(){

        customerRepository.deleteById(customer.getCustomerId());
        assertEquals(Optional.empty(),customerRepository.findById(customer.getCustomerId()));
    }
}

