package ex03.jpa;

import java.util.Date;

import javax.persistence.EntityManager; //Session
import javax.persistence.EntityManagerFactory; //SessionFactory
import javax.persistence.EntityTransaction;	//Transaction
import javax.persistence.Persistence;

import org.junit.Test;

import ex02.annotations.CD;

public class CDTest {

	@Test
	public void testCase1() {
		EntityManagerFactory entityManagerFactory = 
			Persistence.createEntityManagerFactory("Hibernate-JPA"); //META-INF/persistence.xml
	
		
		//nothing but the Session
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		
		CD cd = new CD("Tanhayee", "Sonu Nigam", new Date(), 9.99);
		entityManager.persist(cd); //  session.save(cd);
		
		tx.commit();
		entityManager.close();
		
		entityManagerFactory.close();
	}
}
