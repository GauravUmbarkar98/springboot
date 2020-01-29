package example;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import util.HibernateUtil;

public class CachingTest {

	@Test
	public void testCaching() throws Exception {
		SessionFactory sessionFactory = 
				HibernateUtil.buildSessionFactory(Cat.class);

		//StatelessSession ss = sessionFactory.openStatelessSession();
		
		Session session = sessionFactory.getCurrentSession();
		//session.setFlushMode(FlushMode.AUTO); //see all options - this is for hibernate
		//entitymanager.flushmode in JPA
		
		
		Transaction tx = session.beginTransaction();
		//session.setDefaultReadOnly(true);  //this is for the entire session level read only, this line must be mentioned after transaction but before get()
		
		Cat c = (Cat) session.get(Cat.class, 1);
		//session.setReadOnly(c, true); // now dirty checking is disabled, we willhave to call save or update to reflect data in db
		
		
		//System.out.println(c);
		
		//Cat c2 = (Cat) session.get(Cat.class, 1);
		//Cat c3 = (Cat) session.get(Cat.class, 1);
		
		//c.setAge(599);
		System.out.println(c);
		tx.commit();

		
		Thread.sleep(2000);
		
		session = sessionFactory.getCurrentSession();
		tx = session.beginTransaction();
		c = (Cat) session.get(Cat.class, 1);
		System.out.println(c);
		tx.commit();

		System.out.println("1now using query...");
		session = sessionFactory.getCurrentSession();
		tx = session.beginTransaction();
		List cats = session.createQuery("from Cat").//list();//.
			setCacheable(true).list();
		tx.commit();

		System.out.println("2now using query...");
		session = sessionFactory.getCurrentSession();
		tx = session.beginTransaction();
		cats = session.createQuery("from Cat").
			setCacheable(true).list();
		tx.commit();
		

		sessionFactory.close();
	}
}
