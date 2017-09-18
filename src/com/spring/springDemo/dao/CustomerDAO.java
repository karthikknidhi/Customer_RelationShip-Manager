package com.spring.springDemo.dao;

import java.util.List;

import com.spring.springDemo.entity.Customer;

public interface CustomerDAO {
	
	
	public List<Customer> getCustomer();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);
}
