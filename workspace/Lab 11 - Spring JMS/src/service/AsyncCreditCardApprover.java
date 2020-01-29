package service;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import model.CreditCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class AsyncCreditCardApprover implements MessageListener {

	/*@Autowired
	private MailSender mailSender;*/

	public void onMessage(Message msg) {
		System.out.println("Inside AsyncCreditCardApprover..");
		ObjectMessage objMsg = (ObjectMessage) msg;
		try {
			CreditCard ccInfo = (CreditCard) objMsg.getObject();
			System.out.println("Received request for approving a creditcard..");
			//some real business logic here
			//and then an email with the status/confirmation of the card request
			/*SimpleMailMessage email = new SimpleMailMessage();
			email.setFrom("do-not-reply@company.com");
			email.setSubject("Creditcard approval status!");
			email.setTo(ccInfo.getEmail());
			email.setText("Dear "+ccInfo.getName()+". Your request for creditcard has been approved");
			mailSender.send(email);*/

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
