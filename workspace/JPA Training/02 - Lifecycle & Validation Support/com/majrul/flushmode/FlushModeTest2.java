package com.majrul.flushmode;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.majrul.basics.CD;
import com.majrul.util.JPAUtil;

public class FlushModeTest2 {

	@Test
	public void testFlushing() {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		CD cd = new CD("Titanic", "Celine Dion", new Date(), 100);
		entityManager.persist(cd);
		
		List<CD> list = entityManager.createQuery("select c from CD as c where c.title = 'Titanic'").getResultList();
		
		for(CD cds : list) {
			System.out.println(cds);
		}
		
		tx.commit();
		entityManager.close();
	}
}
