package com.majrul.flushmode;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.majrul.basics.CD;
import com.majrul.util.JPAUtil;

public class FlushModeTest {

	@Test
	public void testFlushing() {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();

		System.out.println("Before persist for loop..");
		for(int i=0; i<100; i++) {
			CD cd = new CD("Title"+i, "Artist"+i, new Date(), 10*i);
			entityManager.persist(cd);
		}
		System.out.println("After persist for loop.. ");
		
		System.out.println("Before executing select query..");
		List<CD> list = entityManager.createQuery("select c from CD as c").getResultList();
		System.out.println("After executing select query..");
		
		System.out.println("Before list iteration for loop..");
		for(CD cd : list) {
			if(cd.getCost() > 50)
				cd.setCost(cd.getCost() - 1);
		}
		System.out.println("After list iteration for loop..");
		
		tx.commit();
		entityManager.close();
	}
}
