package hibernate.inheritance.tableperconcreteclass.union;

import hibernate.inheritance.BankAccount;
import hibernate.inheritance.BillingDetails;
import hibernate.inheritance.CreditCard;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import util.HibernateUtil;

public class BillingDetailsTest {

	@Test
	public void testCase1() {
		SessionFactory sessionFactory = 
				HibernateUtil.buildSessionFactory("hibernate/inheritance/tableperconcreteclass/union/hibernate.cfg.xml");

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		BankAccount bankAcc = new BankAccount();
		bankAcc.setOwner("9Majrul Ansari");
		bankAcc.setNumber("912345");
		bankAcc.setBankName("9ICICI Bank");

		CreditCard creditCard = new CreditCard();
		creditCard.setOwner("9Majrul Ansari");
		creditCard.setNumber("912901234567890");
		creditCard.setType("9VISA");
		creditCard.setExpiryMonth("92");
		creditCard.setExpiryYear("9099");
		
		session.save(bankAcc);
		session.save(creditCard);
		
		tx.commit();
		
		sessionFactory.close();
	}

	@Test
	public void testCase2() {
		SessionFactory sessionFactory = 
				HibernateUtil.buildSessionFactory("hibernate/inheritance/tableperconcreteclass/union/hibernate.cfg.xml");
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		List<BillingDetails> list = session.createQuery("from hibernate.inheritance.BillingDetails").list();
		for(BillingDetails b : list) {
			System.out.println(b.getClass());
			System.out.println("details  "+b);
			System.out.println("----------------");
		}
		
		tx.commit();
		
		sessionFactory.close();
	}
	
}
