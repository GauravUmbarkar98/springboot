package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import util.HibernateUtil;
import ex01.xml.CD;

public class CDTest2 {

	@Test
	public void testCase1() {
		SessionFactory sessionFactory = 
				HibernateUtil.buildSessionFactory(CD.class);

		Session session = sessionFactory.getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		CD cd = (CD) session.get(CD.class, 1);
		System.out.println(cd);
		//session.evict(cd);
		cd.setCost(99);
		//session.saveOrUpdate(cd);
		
		tx.commit();		
		
		sessionFactory.close();
	}
	
}
