package test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;

import org.hibernate.tutorial.domain.Event;
import org.hibernate.tutorial.util.JPAHibernateUtil;
import org.junit.Test;

import dao.BaseDAO;


public class EventTest {

	@Test
	public void testFlushing() {
		EntityManagerFactory emf = JPAHibernateUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		em.setFlushMode(FlushModeType.COMMIT); //when to flush the changes in database
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		for(long i=500;i<=550;i++) {
			Event theEvent = new Event();
			theEvent.setId(i);
			theEvent.setDate(new Date());
			theEvent.setTitle("Each Day is a Holiday"+i);
			
			em.persist(theEvent);
			
			if(i%10 == 0) 
				em.flush(); // 
		}
		System.out.println("*********************");
		List<Event> list = em.createQuery("select e from Event as e").getResultList();
		//will this list contain the above 100 customers data?
		for(Event event: list)
		{
			System.out.println(event);
			System.out.println("-------------------------");
		}
		
		System.out.println("commiting...");
		System.out.println("closing...");
		tx.commit();
		em.close();
		
		System.out.println("committed...");
		System.out.println("closed...");
	}
	
	@Test
	public void testObjectStates()
	{
		EntityManagerFactory emf = JPAHibernateUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		//this one is a transient object
		
		Event theEvent = new Event();
		theEvent.setDate(new Date());
		theEvent.setTitle("Sunday Event");
		System.out.println("Transient object....created");
		
		//attach it with the persistence context
		em.persist(theEvent);
		System.out.println("NOW attached with persistence....");
		
		
		//till we dont close the context, this theEvent object is managed object
		theEvent.setTitle("Its a Holiday");
		
		//committing the transaction and closing the context
		tx.commit();
		em.close();
		System.out.println("commited and close the em...");
		
		//now theEvent object is a detached object
		theEvent.setTitle("My Holiday");
		System.out.println("Now the object is detached....and made some changes in it...");
		
		//to update the state of this detached object, we need to reattach.
		System.out.println("Reattaching .....");
		em = emf.createEntityManager();
		tx = em.getTransaction();
		
		tx.begin();
		
		System.out.println("Merging......");
		em.merge(theEvent);
		
		tx.commit();
		em.close();
		System.out.println("commited and close the em...");
		
		//let's try detaching an object manually
		
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		
		Event anotherEvent = em.find(Event.class,1L);
		em.detach(anotherEvent );// now we are detaching it from JPA
		
		//evict method is used in hibernate
		
		System.out.println("detached...");
		//if we change he title of this customer, will it get updated....
		System.out.println("setting new title....");
		anotherEvent.setTitle("NOT Relaxing Day");
		
		tx.commit();
		em.close();
		System.out.println("another : commited and close the em...");
	}
		
	
	@Test
	public void addEvent()
	{
		Event theEvent = new Event();
		theEvent.setDate(new Date());
		theEvent.setTitle("Our Birthday");
		
		BaseDAO dao = new BaseDAO();
		//dao.insert(theEvent);
		dao.insert(theEvent);
		
	}
	/*
	@Test
	public void getEvent() {
		BaseDAO dao = new BaseDAO();
		
		Event theEvent = dao.select(Event.class, 4L);
		theEvent.setTitle("Her BirthDay");
		System.out.println("updating new title...");
		
		//dao.update(theEvent);
		dao.insertOrUpdate(theEvent);
		System.out.println("updated new title...");
	}
	
	@Test
	public void getAllEvents() {
		BaseDAO dao = new BaseDAO();
		
		List <Event> allEvents = dao.selectAll(Event.class);
		
		System.out.println("Reading all events..");
		
		for (Event theEvent : allEvents) {
			
			System.out.println("Event ID    : "+theEvent.getId());
			System.out.println("Event Title : "+theEvent.getTitle());
			System.out.println("Event Date  : "+theEvent.getDate());
			System.out.println("---------------------------------");
		}
	}
*/
}
