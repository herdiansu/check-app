package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.app.model.Customer;
import com.app.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {
	
	@Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getList() {

        return customerRepository.getList();
    }

    public Customer getByUsername(String kode) {
    	
    	Customer a = customerRepository.getByUsername(kode);
        return a;
    }

    public Customer save(Customer customer) {

        return customerRepository.save(customer);
    }
}
