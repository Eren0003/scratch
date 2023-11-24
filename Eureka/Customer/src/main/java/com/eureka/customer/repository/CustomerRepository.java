package com.eureka.customer.repository;
import com.eureka.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public  interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findById(int customerId);
    @Query(value = "select * from customer where email = ?1",nativeQuery = true)
    Customer existByEmail(String email);
}
