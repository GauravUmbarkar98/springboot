package com.majrul.query.test;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.junit.Test;

import com.majrul.query.Item;
import com.majrul.util.JPAUtil;

public class NativeSQLTest {

	@Test
	public void testNativeSQL() {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createNativeQuery(
				"SELECT * FROM items WHERE initialPrice > 10000");

		List<Object[]> items = query.getResultList();
		for (Object[] item : items)
			System.out.println(Arrays.toString(item));

		
		/*Query query = entityManager.createNativeQuery(
				"SELECT * FROM items WHERE initialPrice > 10000", Item.class);

		List<Item> items = query.getResultList();
		for (Item item : items)
			System.out.println(item);
		 */
		
		entityManager.close();
	}
}
