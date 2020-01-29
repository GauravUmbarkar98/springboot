package com.majrul.query.test;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;

import com.majrul.query.Bid;
import com.majrul.query.Item;
import com.majrul.util.JPAUtil;

public class CriteriaTest {

	@Test
	public void testCriteria() {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		/*
		  CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		  CriteriaQuery<Item> criteria = builder.createQuery(Item.class); 
		  
		  Root<Item> item = criteria.from(Item.class); 
		  criteria.select(item);
		  
		  List<Item> list = entityManager.createQuery(criteria).getResultList();
		  displayItem(list.iterator());
		 */
		
		/*
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Item> criteria = builder.createQuery(Item.class);
		Root<Item> item = criteria.from(Item.class);
		criteria.select(item);
		criteria.distinct(true);		
		
	
		Join<Item, Bid> bids = item.join("bids", JoinType.INNER);
		
		List<Item> list = entityManager.createQuery(criteria).getResultList();
		displayItem(list.iterator());*/
		
		
		/*
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
		Root<Item> itemRoot = criteria.from(Item.class);
		
	
		criteria.select(builder.array(itemRoot.get("name"), itemRoot.get("initialPrice")));
		List<Object[]> valueArray = entityManager.createQuery(criteria).getResultList();
		for ( Object[] values : valueArray ) {
		    System.out.println(values[0]+"\t"+values[1]);
		}
		*/
	}
	
	private static void displayItem(Iterator<Item> itr) {
		while(itr.hasNext()) {
			Item item = (Item) itr.next();
			System.out.println(item);
			//System.out.println(item.getBids());			
		}
	}
}
