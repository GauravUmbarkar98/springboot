package org.vishal.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.vishal.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user1 = new UserDetails();
		
		
		user1.setUserId(1);
		user1.setUserName("Rajesh");
		user1.setAddress("Mumbai");
		user1.setDescription("Admin");
		user1.setJoinedDate(new Date());
		
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().
		configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user1);
		System.out.println("user object persisted...");
		
		session.getTransaction().commit();
		session.close();
		//user1 = null;
		
		/*session = sessionFactory.openSession();
		session.beginTransaction();
		user1 = (UserDetails6) session.get(UserDetails6.class,1);
	
		System.out.println(user1.getUserName());
		System.out.println(user1.getAddr().getStreet());
		System.out.println(user1.getAddr().getCity());
		System.out.println(user1.getAddr().getState());
		System.out.println(user1.getAddr().getPin());
	
		session.getTransaction().commit();
		session.close();*/
		
		
		
	
	}
}
