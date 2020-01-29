package service;

import model.CreditCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class CreditCardProcessorImpl implements CreditCardProcessor {

	@Autowired
	private JmsTemplate jt;

	public void processCreditCardRequest(final CreditCard ccInfo) {
		jt.convertAndSend("MyQueue", ccInfo);
		/*jt.send(destination, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				ObjectMessage msg = session.createObjectMessage(ccInfo);
				return msg;
			}			
		})*/;
	}	
}
