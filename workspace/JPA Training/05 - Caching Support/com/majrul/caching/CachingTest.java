package com.majrul.caching;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Cache;
import javax.persistence.CacheRetrieveMode;
import javax.persistence.CacheStoreMode;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.junit.Test;

import com.majrul.util.JPAUtil;

public class CachingTest {

	@Test
	public void testCaching1() {
		
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		
		EntityManager entityManager1 = entityManagerFactory.createEntityManager();
		Flight flight = entityManager1.find(Flight.class, "AI-123");
		System.out.println(flight);
		entityManager1.close();
		
		Map hints = new HashMap(); 
		hints.put("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
		
		
		EntityManager entityManager2 = entityManagerFactory.createEntityManager();
		Flight flight2 = entityManager2.find(Flight.class, "AI-123");
		System.out.println(flight2);
		entityManager2.close();
		
		
	}
	
	@Test
	public void testCaching2() {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Cache slc = entityManagerFactory.getCache();
		System.out.println("Checking cache contains "+slc.contains(Flight.class, "AI-123"));
		
		slc.evict(Flight.class, "AI-123");
		
		System.out.println("Checking cache contains "+slc.contains(Flight.class, "AI-123"));
		entityManager.close();
	}
}
