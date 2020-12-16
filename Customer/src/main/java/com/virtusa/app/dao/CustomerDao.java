package com.virtusa.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.app.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{

}
