package com.majrul.query.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.junit.Test;

import com.majrul.query.Item;
import com.majrul.util.JPAUtil;

public class BulkUpdateTest {

	@Test
	public void testBulkOperations() {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		
		//Using JPQL
	    /*Query q = entityManager.createQuery("update Item i set i.reservePrice = :res where i.id = :id");
	    q.setParameter("res", 135000.0);
	    q.setParameter("id", 1);
	    int count = q.executeUpdate();
	    System.out.println(count);*/
	    
		//Using CriteriaBuilder
		/*CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaUpdate<Item> q = cb.createCriteriaUpdate(Item.class);
		Root<Item> item = q.from(Item.class);
		q.set("reservePrice", 145000.0);
		q.where(cb.equal(item.get("id"), 1));
		int count = entityManager.createQuery(q).executeUpdate();
	    System.out.println(count);*/
		
	    tx.commit();
	    entityManager.close();
	}
}
