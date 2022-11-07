package com.example.mangodb.repository;

import com.example.mangodb.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,Integer> {

    @Query("{'address.city' :{$in : [?0]}}")
    List<Customer> findByCustomerFromCity(String city);


}
