package hibernate.anyone;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import util.HibernateUtil;

public class OrderTest {

	@Test
	public void testCase1() {
		SessionFactory sessionFactory = 
				HibernateUtil.buildSessionFactory(Order.class, BillingDetails.class);
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		CreditCard creditCard = new CreditCard();
		creditCard.setOwner("Majrul Ansari");
		creditCard.setNumber("412901234567890");
		creditCard.setType("VISA");
		creditCard.setExpiryMonth("12");
		creditCard.setExpiryYear("2099");

		Order order = new Order();
		order.setAmount(4500.0);
		order.setOrderDate(new Date());
		order.setBillingDetails(creditCard);
		
		session.save(order);
		
		tx.commit();

		sessionFactory.close();
	}
}
