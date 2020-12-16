package com.virtusa.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;


import com.virtusa.app.service.CustomerService;
import com.virtusa.app.model.Customer;

@Controller
@RefreshScope
@RequestMapping("/Customer")
@Api(value = "Customer")
@CrossOrigin
public class CustomerController {
	
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	RestTemplate restTemplate;
	

	@Autowired
	private CustomerService service;

	@RolesAllowed({ "user" })
	@GetMapping("/customers")
	@ApiOperation(value = "Get All customer api")
	@ResponseBody
	public List<Customer> getCustomer(@RequestHeader String Authorization){
		log.info("in get all customer method");
		return service.getAllCustomers();
	}

	@RolesAllowed({ "user" })
	@GetMapping("/customer/{id}")
	@ApiOperation(value = "Get customer by ID api")
	@ResponseBody
	public Optional<Customer> getCustomerById(@PathVariable int id, @RequestHeader String Authorization) {
		log.info("find by Id method");
		return service.getCustomerById(id);
	}

	@RolesAllowed({ "user" })
	@PostMapping("/customer")
	@ApiOperation(value = "Post customer api")
	@ResponseBody
	public Customer addCustomer(@RequestBody Customer customer, @RequestHeader String Authorization) {
		log.info("in create customer");
		return service.addCustomer(customer);
	}

	@RolesAllowed({ "user" })
	@DeleteMapping("/customer/{id}")
	@ApiOperation(value = "Delete customer by ID api")
	@ResponseBody
	public Map<String, String> deleteCustomerById(@PathVariable int id, @RequestHeader String Authorization) {
		log.info("find all method");
		service.deleteCustomerById(id);
		HashMap<String,String> res = new HashMap<String, String>();
        res.put("message","done");
		return  res;
	}

	@RolesAllowed({ "user" })
	@PutMapping("/customer/{id}")
	@ApiOperation(value = "Update customer api")
	@ResponseBody
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable int id, @RequestHeader String Authorization){
		return service.updateCustomer(customer,id);
	}

}
