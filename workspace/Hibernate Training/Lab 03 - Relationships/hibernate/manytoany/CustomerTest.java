package hibernate.manytoany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import util.HibernateUtil;

public class CustomerTest {

	@Test
	public void testCase1() {
		SessionFactory sessionFactory = 
				HibernateUtil.buildSessionFactory(Customer.class);
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Customer cust = new Customer();
		cust.setName("Majrul Ansari");
		
		Set<Subscription> subscriptions = new HashSet<Subscription>();
		subscriptions.add(new Magazine("Monthly", 100, "India Today", "News"));
		subscriptions.add(new OnlineService("Monthly", 100, "google.com"));
		cust.setSubscriptions(subscriptions);
		
		session.save(cust);
		tx.commit();

		sessionFactory.close();
	}
}
