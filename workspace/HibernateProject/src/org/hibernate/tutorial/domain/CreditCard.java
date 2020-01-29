package org.hibernate.tutorial.domain;

import java.util.Set;

public class CreditCard {
	
	long cardNumber;
	String cardHolderName;
	Set <CreditCardTransaction> trans;
	
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public Set<CreditCardTransaction> getTrans() {
		return trans;
	}
	public void setTrans(Set<CreditCardTransaction> trans) {
		this.trans = trans;
	}
	
	
}
