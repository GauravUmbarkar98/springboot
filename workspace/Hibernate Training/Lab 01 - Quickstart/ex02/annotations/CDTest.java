package ex02.annotations;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import util.HibernateUtil;

public class CDTest {

	@Test
	public void testCase1() {
		SessionFactory sessionFactory = 
				HibernateUtil.buildSessionFactory("ex02/annotations/hibernate.cfg.xml");
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		CD cd = new CD("Some Title", "Some Artist", new Date(), 9.99);
		session.save(cd);
		
		tx.commit();

		sessionFactory.close();
	}
}
