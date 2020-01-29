package com.vishal.dto;

import java.util.Date;


public class UserDetails 
{
	
	private int userId;
	private String userName;
	private String address;
	private Date joinedDate;
	private String description;
	
	public int getUserId() {
		System.out.println("getUserId()");
		return userId;
	}
	public void setUserId(int userId) {
		System.out.println("setUserId(int)");
		this.userId = userId;
	}
	public String getUserName() {
		System.out.println("getUserName()");
		return userName;
	}
	public void setUserName(String userName) {
		System.out.println("setUserName(String)");
		
		this.userName = userName;
	}
	public String getAddress() {
		System.out.println("getAddress()");
		return address;
	}
	public void setAddress(String address) {
		System.out.println("setAddress(String)");
		this.address = address;
	}
	public Date getJoinedDate() {
		System.out.println("getJoinedDate()");
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		System.out.println("SetJoinedDate(Date)");
		this.joinedDate = joinedDate;
	}
	public String getDescription() {
		System.out.println("getDescription()");
		return description;
	}
	public void setDescription(String description) {
		System.out.println("setDescription(String)");
		this.description = description;
	}
	
	
	
}
