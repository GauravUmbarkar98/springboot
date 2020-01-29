package hibernate.component;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import util.HibernateUtil;

public class UserTest {
	
	@Test
	public void testCase1() {
		SessionFactory sessionFactory = 
				HibernateUtil.buildSessionFactory(User.class);

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
		
		Address address2 = new Address();
		address2.setCity("Pune");
		address2.setStreet("Shaniwar Pethh");
		address2.setZipcode("4201010");
		
		Map<String, String> userAttrs = new HashMap<String, String>();
		userAttrs.put("roles", "admin");
		userAttrs.put("active", "true");
		
		u.setBillingAddress(address);
		u.setShippingAddress(address2);
		//u.setUserAttributes(userAttrs);
		
		session.save(u);
		tx.commit();
		
		sessionFactory.close();
	}
}
