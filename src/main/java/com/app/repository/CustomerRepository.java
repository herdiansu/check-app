package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	@Query("SELECT customer FROM Customer customer")
	List<Customer> getList();

    @Query("SELECT customer FROM Customer customer WHERE customer.usernameOld = :username")
    Customer getByUsername(@Param("username") String username);
}
