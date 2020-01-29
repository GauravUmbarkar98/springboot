package jpa.inheritance.tableperhierarchy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.NaturalId;

@Entity
@DiscriminatorValue("BA")
public class BankAccount extends BillingDetails {

	private String bankName;
	
	
	
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
}
