package example;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class FirstRunThis {

	public static void main(String[] args) throws Exception {
		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory(Product.class);
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Product c = new Product("Nokia Handset",100);
		Serializable id = session.save(c);
		
		tx.commit();
		System.out.println("Primary key of record inserted : "+id);
	}
}
