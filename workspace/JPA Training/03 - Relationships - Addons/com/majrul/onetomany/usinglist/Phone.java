package com.majrul.onetomany.usinglist;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Phone3")
public class Phone {

    @Id
    @Column(name = "PHONE_ID")
    @GeneratedValue
    private int id;
    
    @Column(length=15)
    private String phoneNumber;

    public Phone() {
	}
    
	public Phone(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

    
    
}