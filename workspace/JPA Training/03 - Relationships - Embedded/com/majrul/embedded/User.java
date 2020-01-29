package com.majrul.embedded;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="User1") // fn,ln,un,pass,city,street,zipcode
public class User {

	@Id @GeneratedValue  
	private int id;
	@Column private String firstname;
	@Column private String lastname;
	@Column private String username;
	@Column private String password;
		
	@Embedded
	@AttributeOverrides(value={
			@AttributeOverride(name="city",column=@Column(name="billing_city")),
			@AttributeOverride(name="street",column=@Column(name="billing_street")),
			@AttributeOverride(name="zipcode",column=@Column(name="billing_zipcode")),
		})
	private Address billingAddress;
	
	@Embedded
	@AttributeOverrides(value={
			@AttributeOverride(name="city",column=@Column(name="home_city")),
			@AttributeOverride(name="street",column=@Column(name="home_street")),
			@AttributeOverride(name="zipcode",column=@Column(name="home_zipcode")),
		})
	private Address homeAddress;
	
	/*
	@Embedded
	@AttributeOverrides(value={
			@AttributeOverride(name="city",column=@Column(name="home_city")),
			@AttributeOverride(name="street",column=@Column(name="billing_street")),
			@AttributeOverride(name="zipcode",column=@Column(name="billing_zipcode")),
		})
	private Address homeAddress;
	
	*/
	
	
	public Address getBillingAddress() {
		return billingAddress;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
