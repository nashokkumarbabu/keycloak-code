package com.virtusa.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@Column(name = "customer_id")
	private int customerId;

	public int getCustomerId(){
		return customerId;
	}

	public void setCustomerId(int customerId){
		this.customerId = customerId;
	}

	@Column(name = "customer_short_name", columnDefinition="varchar(10)")
	private String customerShortName;

	public String getCustomerShortName(){
		return customerShortName;
	}

	public void setCustomerShortName(String customerShortName){
		this.customerShortName = customerShortName;
	}

	@Column(name = "organisation_name", columnDefinition="varchar(50)")
	private String organisationName;

	public String getOrganisationName(){
		return organisationName;
	}

	public void setOrganisationName(String organisationName){
		this.organisationName = organisationName;
	}

	@Column(name = "type_of_industry", columnDefinition="varchar(10)")
	private String typeOfIndustry;

	public String getTypeOfIndustry(){
		return typeOfIndustry;
	}

	public void setTypeOfIndustry(String typeOfIndustry){
		this.typeOfIndustry = typeOfIndustry;
	}

	@Column(name = "internal_risk_rating", columnDefinition="varchar(5)")
	private String internalRiskRating;

	public String getInternalRiskRating(){
		return internalRiskRating;
	}

	public void setInternalRiskRating(String internalRiskRating){
		this.internalRiskRating = internalRiskRating;
	}

	@Column(name = "external_risk_rating", columnDefinition="varchar(5)")
	private String externalRiskRating;

	public String getExternalRiskRating(){
		return externalRiskRating;
	}

	public void setExternalRiskRating(String externalRiskRating){
		this.externalRiskRating = externalRiskRating;
	}

	@Column(name = "address", columnDefinition="varchar(50)")
	private String address;

	public String getAddress(){
		return address;
	}

	public void setAddress(String address){
		this.address = address;
	}

	@Column(name = "street", columnDefinition="varchar(10)")
	private String street;

	public String getStreet(){
		return street;
	}

	public void setStreet(String street){
		this.street = street;
	}

	@Column(name = "postcode", columnDefinition="varchar(10)")
	private String postcode;

	public String getPostcode(){
		return postcode;
	}

	public void setPostcode(String postcode){
		this.postcode = postcode;
	}

	@Column(name = "country", columnDefinition="varchar(50)")
	private String country;

	public String getCountry(){
		return country;
	}

	public void setCountry(String country){
		this.country = country;
	}

	@Column(name = "created_date")
	private Date createdDate;

	public Date getCreatedDate(){
		return createdDate;
	}

	public void setCreatedDate(Date createdDate){
		this.createdDate = createdDate;
	}

	@Column(name = "created_by", columnDefinition="varchar(50)")
	private String createdBy;

	public String getCreatedBy(){
		return createdBy;
	}

	public void setCreatedBy(String createdBy){
		this.createdBy = createdBy;
	}

	@Column(name = "updated_by", columnDefinition="varchar(50)")
	private String updatedBy;

	public String getUpdatedBy(){
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy){
		this.updatedBy = updatedBy;
	}

	@Column(name = "modified_date")
	private Date modifiedDate;

	public Date getModifiedDate(){
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate){
		this.modifiedDate = modifiedDate;
	}


public Customer() {  }

public Customer(	
		
		int customerId,
	
		
		String customerShortName,
	
		
		String organisationName,
	
		
		String typeOfIndustry,
	
		
		String internalRiskRating,
	
		
		String externalRiskRating,
	
		
		String address,
	
		
		String street,
	
		
		String postcode,
	
		
		String country,
	
		
		Date createdDate,
	
		
		String createdBy,
	
		
		String updatedBy,
	
		
		Date modifiedDate
	
) {
		this.customerId = customerId;
	
		this.customerShortName = customerShortName;
	
		this.organisationName = organisationName;
	
		this.typeOfIndustry = typeOfIndustry;
	
		this.internalRiskRating = internalRiskRating;
	
		this.externalRiskRating = externalRiskRating;
	
		this.address = address;
	
		this.street = street;
	
		this.postcode = postcode;
	
		this.country = country;
	
		this.createdDate = createdDate;
	
		this.createdBy = createdBy;
	
		this.updatedBy = updatedBy;
	
		this.modifiedDate = modifiedDate;
	
}


}
