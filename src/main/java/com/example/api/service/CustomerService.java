package com.example.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.domain.Customer;
import com.example.api.repository.CustomerRepository;

@Service
public class CustomerService {

	private CustomerRepository repository;

	@Autowired
	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}

	public List<Customer> findAll() {
		return repository.findAllByOrderByNameAsc();
	}

	public Optional<Customer> findById(Long id) {
		return repository.findById(id);
	}
	
	public Customer save(Customer customer) {
		return repository.save(customer);
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id); 
	}
	
	public Customer updateCustomer(Long code, Customer customer) {
		Optional<Customer> customerSave = findById(code);
		BeanUtils.copyProperties(customer, customerSave, "code");
		return repository.save(customerSave.get());
	}
	
	

}
