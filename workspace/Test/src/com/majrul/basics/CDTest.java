package com.majrul.basics;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import com.majrul.util.BaseDao;
import com.majrul.util.JPAUtil;
public class CDTest {
	@Test
	public void testCase1() {
		
		CD cd = new CD("Friends", "KK", new Date(), 8.88);
		System.out.println("CD created..");
		
		BaseDao dao = new BaseDao();
		System.out.println("BaseDao created..");
		dao.merge(cd);
		System.out.println("Object stored..");
	}
	@Test
	public void testCase2() {
		BaseDao dao = new BaseDao();
		CD cd = dao.find(CD.class, 21);
		System.out.println(cd);
	}
	@Test
	public void testCase3() {
		BaseDao dao = new BaseDao();
		CD cd = dao.find(CD.class, 21);
		System.out.println(cd);
		
		//by now the CD instance in detached
		cd.setCost(19.99); //changes won't be reflected in the database
		
		//re-attaching a detached instance
		dao.merge(cd);
	}
	@Test
	public void testCase4() {
		//assuming we have a CD object with some fields modified by the user
		CD cd = new CD();
		cd.setId(1);
		cd.setArtist("New Artist");
		cd.setTitle("Old Title");
		cd.setCost(29.99);
		cd.setPurchaseDate(new Date());

		BaseDao dao = new BaseDao();
		dao.merge(cd);
	}	

}
