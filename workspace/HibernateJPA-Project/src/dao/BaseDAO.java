package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.tutorial.util.JPAHibernateUtil;

//transaction code should not be in the DAO

//transaction management should be managed by service layer

// and DAO will participate in service layer

//distributed transaction use JTA+JPA

public class BaseDAO {
	
	/*public void insertOrUpdate(Object obj) {
		//step no.1 we need to create/obtain the SessionFactory object
		SessionFactory sessionFactory = JPAHibernateUtil.getSessionFactory();
		
		//step no.2 we need to create/obtain a session object
		Session session = sessionFactory.getCurrentSession();
		
		//step no.3 we need to bind the session with a transaction
		Transaction tx = session.beginTransaction();
		
		//now we can insert/update/delete/select whatever we want
		
		//saveOrUpdate will generate:
		//insert query for transient objects
		//update query for detached objects
		
		//session.merge(obj); // save method generates insert query
		session.saveOrUpdate(obj); // save method generates insert query
		
		tx.commit();
	}*/

	public void insert(Object obj) {
		//step no.1 we need to create/obtain the EntityManagerFactory object
		EntityManagerFactory emf = JPAHibernateUtil.getEntityManagerFactory();
		
		//step no.2 we need to create/obtain a EntityManager object
		EntityManager em = emf.createEntityManager();
		
		//step no.3 we need to bind the session with a transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//now we can insert/update/delete/select whatever we want
		
		em.persist(obj); // save method generates insert query
		
		tx.commit();
	}
	
	/*public void update(Object obj) {
		//step no.1 we need to create/obtain the SessionFactory object
		SessionFactory sessionFactory = JPAHibernateUtil.getSessionFactory();
		
		//step no.2 we need to create/obtain a session object
		Session session = sessionFactory.getCurrentSession(); // if not it will create a new session
		
		//step no.3 we need to bind the session with a transaction
		Transaction tx = session.beginTransaction();
		
		//now we can insert/update/delete/select whatever we want
		
		session.update(obj); // update method generates update query
		
		tx.commit(); // connection is auto closed
	}
	
	public <E> E select(Class<E> clazz, Serializable pk) {
		
		SessionFactory sessionFactory = JPAHibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession(); // in project we use getCurrentSession()
		
		try
		{
			E e = (E) session.get(clazz, pk); // get method generates select query
			return e;
		}
		finally {
			session.close();
		}
	}
	
	public <E> List<E> selectAll(Class<E> clazz)
	{
		SessionFactory sessionFactory = JPAHibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession(); // in project we use getCurrentSession()
		
		try {
			//SQL : select t.* from table_name as t
			//HQL : select c from Events as e
			
			String hql = "select o from " + clazz.getName() + " as o";
			Query query = session.createQuery(hql); // HQL
			return query.list();
		}
		finally {
			session.close();
		}
	}*/
}
