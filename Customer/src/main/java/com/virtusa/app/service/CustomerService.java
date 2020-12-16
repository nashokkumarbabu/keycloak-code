package com.virtusa.app.service;

import com.virtusa.app.model.UserProfile;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;


import com.virtusa.app.dao.CustomerDao;
import com.virtusa.app.model.Customer;

@Service
public class CustomerService {

    @Autowired
	RestTemplate restTemplate;

	@Autowired
	private UserProfile userProfile;

	@Autowired
	private CustomerDao dao;

	public List<Customer> getAllCustomers(){
		return dao.findAll();
	}

	public Optional<Customer> getCustomerById(int id) {
		return dao.findById(id);
	}

	public Customer addCustomer(Customer customer) {
		return dao.save(customer);
	}

	public void deleteCustomerById(int id) {
		dao.deleteById(id);;
	}

	public Customer updateCustomer(Customer customer,int id){
		Customer o = dao.findById(id).orElse(new Customer());
			
		o.setCustomerId(customer.getCustomerId());
			
		o.setCustomerShortName(customer.getCustomerShortName());
		
		o.setOrganisationName(customer.getOrganisationName());
		
		o.setTypeOfIndustry(customer.getTypeOfIndustry());
		
		o.setInternalRiskRating(customer.getInternalRiskRating());
		
		o.setExternalRiskRating(customer.getExternalRiskRating());
		
		o.setAddress(customer.getAddress());
		
		o.setStreet(customer.getStreet());
		
		o.setPostcode(customer.getPostcode());
		
		o.setCountry(customer.getCountry());
		
		o.setCreatedDate(customer.getCreatedDate());
		
		o.setCreatedBy(customer.getCreatedBy());
		
		o.setUpdatedBy(customer.getUpdatedBy());
		
		o.setModifiedDate(customer.getModifiedDate());
		
		return dao.save(o);
	}
	
    
}
