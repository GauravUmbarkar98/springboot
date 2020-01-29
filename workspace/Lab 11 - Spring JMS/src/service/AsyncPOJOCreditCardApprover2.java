package service;

import model.CreditCard;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class AsyncPOJOCreditCardApprover2 {

	/*@Autowired
	private MailSender mailSender;*/

	@JmsListener(destination = "MyQueue")
	public void approve(CreditCard ccInfo) {
		System.out.println("Inside AsyncPOJOCreditCardApprover2..");
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
