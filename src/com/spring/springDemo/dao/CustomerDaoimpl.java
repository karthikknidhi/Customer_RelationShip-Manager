package com.spring.springDemo.dao;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.springDemo.entity.Customer;

@Repository
public class CustomerDaoimpl implements CustomerDAO {

	@Autowired
	private SessionFactory sesionfactory;
	
	
	@Override
	public List<Customer> getCustomer() {
		
	Session currentSession = sesionfactory.getCurrentSession();
	
	Query<Customer> query = currentSession.createQuery("from Customer order by lastName",Customer.class);
		
	List<Customer> customers = query.getResultList();
	
	
		
	return customers;
	}


	@Override
	public void saveCustomer(Customer customer) {
		
		Session currentSession = sesionfactory.getCurrentSession();
		
		currentSession.saveOrUpdate(customer);
		
	}


	@Override
	public Customer getCustomer(int id) {
		Session currentSession = sesionfactory.getCurrentSession();
		
		Customer customer = currentSession.get(Customer.class,id);
		
		return customer;
	}


	@Override
	public void deleteCustomer(int id) {
		
		Session currentSession = sesionfactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from Customer where id = :customerId");
		query.setParameter("customerId", id);
		query.executeUpdate();
	}

}
