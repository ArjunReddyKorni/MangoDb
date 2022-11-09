//package com.example.mangodb.service;
//
//import com.example.mangodb.domain.Address;
//import com.example.mangodb.domain.Customer;
//import com.example.mangodb.repository.CustomerRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import java.util.List;
//import java.util.Optional;
//import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.any;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class CustomerServiceImplTest {
//
//    @Mock
//    private CustomerRepository customerRepository;
//    @InjectMocks
//    CustomerServiceImpl customerService;
//    private Customer customer,customer1;
//    private Address address,address1;
//    List<Customer> customers;
//
//    @BeforeEach
//    void setUp() {
//        address = new Address("Hyd","Ts","india","235654");
//        address1 = new Address("Goa","Ts","india","235654");
//        customer = new Customer(22,"Arjun","Arjun@123",address);
//        customer1 = new Customer(32,"Arjun","Arjun@123",address1);
//        customers = customerRepository.findAll();
//    }
//
//    public void saveCustomer(){
////        when(customerRepository.findById(customer.getCustomerId())).thenReturn(Optional.ofNullable(null));
//        when(customerRepository.save(any())).thenReturn(customer);
//
//
//
////        when(customerRepository.save(any())).thenReturn(customer);
////        assertEquals(customer,customerService.addCustomer(customer));
////        verify(customerRepository,times(1)).save(any());
////        verify(customerRepository,times(1)).findById(any());
//
//
////        when(customerRepository.findById(customer.saveCustid())).thenReturn(Optional.ofNullable(null));
////        when(customerRepository.save(any())).thenReturn(customer);
////        assertEquals(customer,customerService.saveCustomer(customer));
////        verify(customerRepository,times(1)).save(any());
////        verify(customerRepository,times(1)).findById(any());
//    }
//
//
//}
