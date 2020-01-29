package service;

import model.CreditCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class AsyncPOJOCreditCardApprover {

	/*@Autowired
	private MailSender mailSender;*/

	public void approve(CreditCard ccInfo) {
		System.out.println("Inside AsyncPOJOCreditCardApprover..");
		//some real business logic here
		System.out.println("Received request for approving a creditcard..");		
		//and then an email with the status/confirmation of the card request
		/*SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom("do-not-reply@company.com");
		email.setSubject("Creditcard approval status!");
		email.setTo(ccInfo.getEmail());
		email.setText("Dear "+ccInfo.getName()+". Your request for creditcard has been approved");
		mailSender.send(email);*/
	}
}
