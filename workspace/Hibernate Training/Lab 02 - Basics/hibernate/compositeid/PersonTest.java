package hibernate.compositeid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import util.HibernateUtil;

public class PersonTest {

	@Test
	public void testCase1() {
		SessionFactory sessionFactory = 
			HibernateUtil.buildSessionFactory(Person.class);
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Person p = new Person(new Person.Id("India",12345), "Majrul", 99);
	    session.save(p);	    
		
		tx.commit();

		sessionFactory.close();
	}
}
