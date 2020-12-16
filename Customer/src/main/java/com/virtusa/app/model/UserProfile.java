package com.virtusa.app.model;

import java.io.Serializable;

public class UserProfile implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
	private String email;
	private String firstName;
	private String lastName;
    private Boolean isUser;
    private Boolean isLender;

	public UserProfile(String id, String email, String firstName, String lastName) {
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Boolean getUser() {
		return isUser;
	}

	public void setUser(Boolean user) {
		isUser = user;
	}

	public Boolean getLender() {
		return isLender;
	}

	public void setLender(Boolean lender) {
		isLender = lender;
	}

	@Override
	public String toString() {
		return "UserProfile{" +
				"id='" + id + '\'' +
				", email='" + email + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", isUser=" + isUser +
				", isLender=" + isLender +
				'}';
	}
}