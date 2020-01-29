package ex1;

import org.springframework.beans.factory.annotation.Value;

public class SavingsAccount {

	//TODO 2: initialize the defaultLocale field with the system locale using EL.
	//Refer to slide no. 78 for details.
	@Value("#{systemProperties['user.county'] ?: 'UK' }")
	private String accountCountry;
	
	public float withdraw(float amount) {
		//some error handling here which is locale specific
		amount = amount - amount  * 0.25f;
		System.out.println("from "+accountCountry+" withdrawing amount : "+amount+" for SavingsAccount");
		return amount;
	}
}
