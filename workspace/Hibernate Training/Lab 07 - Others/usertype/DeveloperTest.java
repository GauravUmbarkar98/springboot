package usertype;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class DeveloperTest {

	public static void main(String[] args) throws Exception {
		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory(Developer.class);
	    Session session = sessionFactory.getCurrentSession();
	    Transaction transaction = session.beginTransaction();
	    
	    Developer d = new Developer("Majrul",new Boolean(true));
	    
	    session.save(d);
	    
	    transaction.commit();
	    
	}
}
