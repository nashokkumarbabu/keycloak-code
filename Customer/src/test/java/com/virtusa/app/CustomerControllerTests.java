package com.virtusa.app;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;



import com.virtusa.app.controller.CustomerController;
import com.virtusa.app.model.Customer;
import com.virtusa.app.service.CustomerService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CustomerControllerTests {
	
	@Mock
	CustomerService Service;
	
	@InjectMocks
	CustomerController Controller;
	
	@Test
	public void getCustomerTest() {
		when(Service.getAllCustomers()).thenReturn(Stream
				.of(new Customer(),
					new Customer()).collect(Collectors.toList()));
		assertEquals(2, Controller.getCustomer(null).size());
	}
	
	@Test
	public void getCustomerByIdTest() {
		int id = 1;
		Optional<Customer> customer= Optional.of(new Customer());
		when(Service.getCustomerById(id))
				.thenReturn(customer);
		assertEquals(customer, Controller.getCustomerById(id, null));
	}
	
	@Test
	public void addCustomerTest() {
		Customer customer = new Customer();
		when(Service.addCustomer(customer)).thenReturn(customer);
		assertEquals(customer, Controller.addCustomer(customer, null));
	}

	@Test
	public void deleteCustomerByIdTest() {
		Customer customer = new Customer();
		Controller.deleteCustomerById(customer.getCustomerId(), null);
	 	verify(Service, times(1)).deleteCustomerById(customer.getCustomerId());
	}
	
	@Test
	public void updateCustomerTest() {
		Customer customer = new Customer();
		when(Service.updateCustomer(customer,customer.getCustomerId())).thenReturn(customer);
		assertEquals(customer, Controller.updateCustomer(customer,customer.getCustomerId(), null));
	}
}
