import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.tutorial.domain.CreditCard;
import org.hibernate.tutorial.domain.CreditCardTransaction;
import org.hibernate.tutorial.domain.Event;
import org.junit.Test;

import dao.BaseDAO;


public class CreditCardTest {

	@Test
	public void addCard()
	{
		CreditCard theCard = new CreditCard();
		theCard.setCardHolderName("Vishal Dawane");
		System.out.println("CreditCard Created...");
		
	
		CreditCardTransaction cct1 = new CreditCardTransaction();
		cct1.setCard(theCard);
		cct1.setAmount(2400);
		System.out.println("CreditCardTransaction 1 Created...");
		
		CreditCardTransaction cct2 = new CreditCardTransaction();
		cct2.setCard(theCard);
		cct2.setAmount(3600);
		System.out.println("CreditCardTransaction 2 Created...");
		
		//theCard.getTrans().add(cct1);
		//theCard.getTrans().add(cct2);
		//System.out.println("Both CreditCardTransactions added to card's transaction set...");
		
		BaseDAO dao = new BaseDAO();
		//dao.insert(theEvent);
		dao.insertOrUpdate(theCard);
		System.out.println("CreditCard inserted to DB");
		dao.insertOrUpdate(cct1);
		System.out.println("CreditCardTransaction 1 inserted to DB");
		dao.insertOrUpdate(cct2);
		System.out.println("CreditCardTransaction 2 inserted to DB");
		
	}
	
	@Test
	public void getCard() {
		BaseDAO dao = new BaseDAO();
		
		CreditCard theCard = dao.select(CreditCard.class, 1L);
		
		System.out.println("Card Number : "+theCard.getCardNumber());
		System.out.println("Card Holder : "+theCard.getCardHolderName());


	}
	
	@Test
	public void getAllEvents() {
		BaseDAO dao = new BaseDAO();
		
		List <Event> allEvents = dao.selectAll(Event.class);
		
		System.out.println("Reading all events..");
		
		for (Event theEvent : allEvents) {
			
			System.out.println("Event ID    : "+theEvent.getId());
			System.out.println("Event Title : "+theEvent.getTitle());
			System.out.println("Event Date  : "+theEvent.getDate());
			System.out.println("---------------------------------");
		}
	}

}
