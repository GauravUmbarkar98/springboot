package ex1;

import org.springframework.beans.factory.annotation.Value;

public class CurrentAccount {

	//TODO 2: initialize the defaultLocale field with the system locale using EL.
	//Refer to slide no. 78 for details.
	@Value("#{savings.withdraw(5000)}")
	private float amount;
	
	public void deposit() {
		//some error handling here which is locale specific
		System.out.println("Depositing amount : "+amount+" for CurrentAccount "); 
	}
}
