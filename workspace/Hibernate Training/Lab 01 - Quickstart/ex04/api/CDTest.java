package ex04.api;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import util.HibernateUtil;

import ex01.xml.CD;


public class CDTest {

	/*
	 * Fetching a record from the database using Session.get() method
	 */
	@Test
	public void testCase1() {
		SessionFactory sessionFactory = 
				HibernateUtil.buildSessionFactory("ex01/xml/hibernate.cfg.xml");
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		CD cd = (CD) session.get(CD.class, 1);
		System.out.println(cd);
		
		tx.commit();		

		sessionFactory.close();
	}
	
	/*
	 * Fetching a record from the database using EntityManager.find() method
	 */
	@Test
	public void testCase2() {
		EntityManagerFactory entityManagerFactory = 
			Persistence.createEntityManagerFactory("Hibernate-JPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		
		ex02.annotations.CD cd = (ex02.annotations.CD) entityManager.find(ex02.annotations.CD.class, 1);
		System.out.println(cd);
		
		
		tx.commit();
		entityManager.close();
		
		entityManagerFactory.close();
	}
	
	/*
	 * Understanding Detached state in Hibernate. Same applies to JPA as well
	 */
	@Test
	public void testCase3() {
		SessionFactory sessionFactory = 
				HibernateUtil.buildSessionFactory("ex01/xml/hibernate.cfg.xml");
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//CD cd = new CD()
		
		CD cd = (CD) session.get(CD.class, 1);
		System.out.println(cd);
		
		tx.commit(); //remember, commit will cause the session to close
		
		//now the CD instance in detached
		cd.setCost(89.99); //changes won't be reflected in the database
		
		//re-attaching a detached instance
		session = sessionFactory.getCurrentSession();
		tx = session.beginTransaction();
		
		session.update(cd);
		
		tx.commit();
		
		sessionFactory.close();
	}

	/*
	 * Understanding difference between saveOrUpdate and merge method.
	 * There is no saveOrUpdate method in JPA. Only merge method is available
	 */
	@Test
	public void testCase4() {
		SessionFactory sessionFactory = 
				HibernateUtil.buildSessionFactory("ex01/xml/hibernate.cfg.xml");
		
		//assuming we have a CD object with some fields modified by the user
		CD cd = new CD();
		//cd.setId(4);
		cd.setArtist("New Artist44");
		cd.setTitle("New Title44");
		cd.setCost(44.44);
		cd.setPurchaseDate(new Date());
		
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		//insert or update based on whether the object passed is transient or detached
		session.saveOrUpdate(cd);
	
		
		tx.commit(); 
		
		sessionFactory.close();
	}	
}
