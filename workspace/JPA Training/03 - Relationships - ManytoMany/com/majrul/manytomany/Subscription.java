package com.majrul.manytomany;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name="Subscription1")
public class Subscription {

	@Id
	@GeneratedValue
	private int id;
	
	private String type;
	private int duration;

	@ManyToMany
	@JoinTable(name="CustomerSubscriptionLink1", 
			joinColumns={@JoinColumn(name="sub_id")},
			inverseJoinColumns={@JoinColumn(name="cust_id")})
	private Set<Customer> customers;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Set<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}
}
