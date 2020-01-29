package hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import util.HibernateUtil;

public class UserTest {
	
	@Test
	public void testCase1() {
		SessionFactory sessionFactory = 
				HibernateUtil.buildSessionFactory(User.class, Address.class);

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		User  u = new User();
		u.setFirstname("Majrul");
		u.setLastname("Ansari");
		u.setUsername("majrul");
		u.setPassword("majrul123");
		
		Address address = new Address();
		address.setCity("Mumbai");
		address.setStreet("Vikhroli");
		address.setZipcode("400083");
		
		u.setAddress(address);
		address.setUser(u);
		
		session.save(u);
		tx.commit();

		sessionFactory.close();
	}
}
