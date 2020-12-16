package com.virtusa.app;


import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;



import com.virtusa.app.service.CustomerService;
import com.virtusa.app.model.Customer;
import com.virtusa.app.dao.CustomerDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTests {
    
    @Autowired
	private CustomerService service;

	@MockBean
	private CustomerDao dao;

	@Test
	public void getAllCustomerTest() {
		when(dao.findAll()).thenReturn(Stream
				.of(new Customer(
					// --TO DO 
					// please write the entity required feilds
					)).collect(Collectors.toList()));
		assertEquals(1, service.getAllCustomers().size());
	}

	@Test
	public void getCustomerByIdTest() {
		int id = 1;
		Optional<Customer>  customer= Optional.of(new Customer());
		when(service.getCustomerById(id))
				.thenReturn(customer);
		assertEquals(customer, service.getCustomerById(id));
	}

	@Test
	public void addCustomerTest() {
		// TO DO
		// please write the entity required feilds 
		// example
		// User user = new User(999, "Pranya", 33, "Pune");
		Customer customer = new Customer();
		when(service.addCustomer(customer)).thenReturn(customer);
		assertEquals(customer, service.addCustomer(customer));
	}

	@Test
	public void deleteCustomerByIdTest() {
		// TO DO 
		// please write the entity required feilds 
		// example
		// User user = new User(999, "Pranya", 33, "Pune");
		Customer customer = new Customer();
		service.deleteCustomerById(customer.getCustomerId());
		verify(dao, times(1)).deleteById(customer.getCustomerId());
	}

	@Test
	public void updateCustomerTest() {
		// TO DO
		// please write the entity required feilds 
		// example
		// User user = new User(999, "Pranya", 33, "Pune");
		Customer customer = new Customer();
		when(dao.save(customer)).thenReturn(customer);
		assertEquals(customer, dao.save(customer));
	}
}
