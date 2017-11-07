package com.chofman.helloselenium.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user", catalog = "testlocal_systemdata")
public class User {

	private String username;
	private String firstName;
	private String middleName;
	private String lastName;

	public User() {
	}

	public User(String username) {
		this.username = username;
	}
	
	public User(String username, String firstName, String middleName, String lastName) {
		this.username = username;
		this.setFirstName(firstName);
		this.setMiddleName(middleName);
		this.setLastName(lastName);
	}

	@Id
	@Column(name = "username")
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "firstName")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "middleName")
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "lastName")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
