package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
public class StoreManagement {

	@Autowired
	CustomerService customerservice;

	@GetMapping("/customer")
	public List<Customer> getAllCustomerDetails() {
		return customerservice.getAllCustomerDetails();
	}

	@PostMapping("/customers")
	public Customer saveCustomerDetails(@RequestBody Customer customer) {
		return customerservice.saveCustomerDetails(customer);
	}

	@GetMapping("/customers/{field}")
	public List<Customer> getCustomerWithSorting(@PathVariable String field) {
		List<Customer> sortcustomer = customerservice.getCustomerWithSorting(field);
		return sortcustomer;
	}

	@GetMapping("/pagination/{offset}/{pageSize}")
	public Page<Customer> getCustomerWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
		Page<Customer> sortProducts = customerservice.getCustomerWithPagination(offset, pageSize);
		return sortProducts;
	}
	
	@PutMapping("/customer/{id}")
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer, @PathVariable Integer id) {
              
    	boolean updateAccepted = customerservice.updateCustomer(customer,id);
    	
    	if(updateAccepted)
    	{
    		return ResponseEntity.ok("details updated");
    	}
    	else
    	{
    		return ResponseEntity.ok("details not updated");
    	}
    }
	
}
