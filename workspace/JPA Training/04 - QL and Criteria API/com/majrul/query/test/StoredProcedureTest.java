package com.majrul.query.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.junit.Test;

import com.majrul.query.Item;
import com.majrul.util.JPAUtil;

public class StoredProcedureTest {

	@Test
	public void testProcedures() {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		StoredProcedureQuery procedure = entityManager.createNamedStoredProcedureQuery("ReadName");
		procedure.setParameter("item_pk", 1);
		procedure.execute();
		String name = (String) procedure.getOutputParameterValue("item_name");
		System.out.println(name);
		
		//Below code doesn't works with Hibernate and Oracle
		/*StoredProcedureQuery procedure = entityManager.createStoredProcedureQuery("read_items", Item.class);
		procedure.registerStoredProcedureParameter("out_items_cur", Object.class, ParameterMode.REF_CURSOR);
		
		boolean execute = procedure.execute();
		List<Item> items = (List<Item>) procedure.getOutputParameterValue("out_items_cur");
		for(Item item : items)
			System.out.println(item);*/
		
		entityManager.close();
	}
}
