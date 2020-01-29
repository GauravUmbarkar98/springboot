package com.majrul.inheritance.strategy3.mappedsuperclass;

import javax.persistence.Entity;

@Entity(name="BankAccount3")
public class BankAccount extends BillingDetails {

	private String bankName;
	
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
}
