package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import util.HibernateUtil;
import events.CustomInterceptor;
import ex01.xml.CD;

public class CDTest {

	@Test
	public void testCase1() {
		SessionFactory sessionFactory = 
				HibernateUtil.buildSessionFactory(CD.class);

		Session session = sessionFactory.withOptions()
							.interceptor(new CustomInterceptor())
							.openSession();
		
		Transaction tx = session.beginTransaction();
		
		CD cd = (CD) session.get(CD.class, 1);
		System.out.println(cd);
		//session.evict(cd);
		cd.setCost(99);
		//session.saveOrUpdate(cd);
		
		tx.commit();		
		session.close();
		
		sessionFactory.close();
	}
	
}
