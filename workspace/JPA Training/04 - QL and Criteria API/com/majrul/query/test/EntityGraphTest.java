package com.majrul.query.test;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Test;

import com.majrul.query.Item;
import com.majrul.util.JPAUtil;

public class EntityGraphTest {

	@Test
	public void testEntityGraph() {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityGraph graph = entityManager.getEntityGraph("itemCategoriesGraph");
		Map hints = new HashMap();
		hints.put("javax.persistence.fetchgraph", graph);

		Item i = (Item) entityManager.find(Item.class, 1, hints);
	    System.out.println(i);

	    
	    entityManager.close();
	}
}
