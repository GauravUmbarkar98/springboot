package test;

import model.CreditCard;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.CreditCardProcessor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CreditCardProcessorTest {

	@Autowired
	private CreditCardProcessor cardProcessor;
	
	@Test
	public void execute() {
		CreditCard card = new CreditCard();
		card.setName("Majrul Ansari");
		card.setOccupation("Java Padane Wala");
		card.setEmail("majrul@gmail.com");
		card.setAddress("Mumbai");
		cardProcessor.processCreditCardRequest(card);
	}

}
