package test;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import util.HibernateUtil;
import example.Summary;

public class SummaryTest {

	@Test
	public void testSummary() {
		SessionFactory sessionFactory = 
				HibernateUtil.buildSessionFactory(Summary.class);
		
        Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();	
		
		List l = (List) session.createQuery("from Summary s").list();
		System.out.println(l);

		tx.commit();		
        session.close();
        
		sessionFactory.close();
	}
}
