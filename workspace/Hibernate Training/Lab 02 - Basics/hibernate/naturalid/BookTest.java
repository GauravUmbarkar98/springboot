package hibernate.naturalid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import util.HibernateUtil;

public class BookTest {

	@Test
	public void testCase1() {
		SessionFactory sessionFactory = 
				HibernateUtil.buildSessionFactory(Book.class);
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Book book = new Book();
		book.setIsbn(1234567890);
		book.setTitle("Beginning Hibernate");
		book.setAuthor("Jeff Linwood");
		book.setPublication("Apress");
		
		session.save(book);
		tx.commit();
		
		sessionFactory.close();
	}
	
	@Test
	public void testCase2() {
		SessionFactory sessionFactory = 
				HibernateUtil.buildSessionFactory(Book.class);
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Book book = (Book) session.get(Book.class, 1);
		book.setId(123); //error
		book.setIsbn(9876543210L); //error
		
		tx.commit();

		sessionFactory.close();
	}
	
	@Test
	public void testCase3() {
		SessionFactory sessionFactory = 
				HibernateUtil.buildSessionFactory(Book.class);
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		Book book = (Book) session.bySimpleNaturalId(Book.class).load(1234567890L);
		System.out.println(book);
		
		tx.commit();
		
		sessionFactory.close();
		
	}

}
