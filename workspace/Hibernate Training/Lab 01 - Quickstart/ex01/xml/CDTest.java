package ex01.xml;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import util.HibernateUtil;

public class CDTest {

	@Test
	public void testCase1() {
		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory("ex01/xml/hibernate.cfg.xml");
		Session session = sessionFactory.getCurrentSession();
		
		
		Transaction tx = session.beginTransaction();
		
		CD cd = new CD("Zhingat", "AjayAtul", new Date(), 19.99);
		session.save(cd); //save method is used for generating an insert statement
		
		tx.commit();
		
		//sessionFactory.close();
	}
}
