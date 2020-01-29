package usertype;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class UserTest {

	public static void main(String[] args) throws Exception {
		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory(Developer.class);
	    Session session = sessionFactory.getCurrentSession();
	    Transaction transaction = session.beginTransaction();
	    
		User  u = new User();
		u.setFirstname("Majrul");
		u.setLastname("Ansari");
		u.setUsername("majrul");
		u.setPassword("majrul123");
		
		Address address = new Address();
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		
		Address address2 = new Address();
		address2.setCity("Pune");
		address2.setState("Maharashtra");
		address2.setCountry("India");
		
		u.setBillingAddress(address);
		u.setHomeAddress(address2);
		
		session.save(u);
	    
	    transaction.commit();

	    session = sessionFactory.getCurrentSession();
	    transaction = session.beginTransaction();
	    
		u = (User) session.get(User.class, 1);
		System.out.println(u.getFirstname());
		System.out.println(u.getHomeAddress().getCity());
		System.out.println(u.getBillingAddress().getCity());
	    
	    transaction.commit();
	
	}
}
