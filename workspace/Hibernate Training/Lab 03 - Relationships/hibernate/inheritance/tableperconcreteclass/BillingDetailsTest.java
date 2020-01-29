package hibernate.inheritance.tableperconcreteclass;

import hibernate.inheritance.BankAccount;
import hibernate.inheritance.BillingDetails;
import hibernate.inheritance.CreditCard;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import util.HibernateUtil;

public class BillingDetailsTest {

	@Test
	public void testCase1() {
		SessionFactory sessionFactory = 
				HibernateUtil.buildSessionFactory("hibernate/inheritance/tableperconcreteclass/hibernate.cfg.xml");
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		BankAccount bankAcc = new BankAccount();
		bankAcc.setOwner("jack dmelo");
		bankAcc.setNumber("92345");
		bankAcc.setBankName("hdfc Bank");

		CreditCard creditCard = new CreditCard();
		creditCard.setOwner("jill smith");
		creditCard.setNumber("999934567890");
		creditCard.setType("VISA");
		creditCard.setExpiryMonth("12");
		creditCard.setExpiryYear("2099");
		
		session.save(bankAcc);
		session.save(creditCard);
		
		tx.commit();
	
		sessionFactory.close();
	}
}
