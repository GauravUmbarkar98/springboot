package com.majrul.locking;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;

import com.majrul.util.JPAUtil;

public class LockingTest {

	public static void main(String[] args) {
		TestSession1 s1 = new TestSession1();
		TestSession2 s2 = new TestSession2();
		new Thread(s1).start();
		new Thread(s2).start();
		System.out.println("end of main...");
	}

	static class TestSession1 implements Runnable {
	
		public void run() {
			try {
				//Thread.sleep(5000);
				EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
				EntityManager entityManager = entityManagerFactory.createEntityManager();
				EntityTransaction tx = entityManager.getTransaction();
				tx.begin();
				
				Product p = entityManager.find(Product.class, 1);
				System.out.println("Thread-1: Version " + p.getVersion() + " before update");
								
				System.out.println("lockmodetype is pessimistic force increment via test session1 ..before lock "+p.getVersion());
				entityManager.lock(p, LockModeType.PESSIMISTIC_FORCE_INCREMENT);
				System.out.println("lockmodetype is pessimistic force increment via test session1 ..after lock "+p.getVersion());
	
				p.setPrice(p.getPrice() + 10);
				
				//Product latestObject = entityManager.find(Product.class, p.getId());
				//p.setVersion(latestObject.getVersion());
			
	
				tx.commit();
				entityManager.close();
				System.out.println("Thread-1: Version " + p.getVersion() + " after update");
				//entityManagerFactory.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	static class TestSession2 implements Runnable {
	
		public void run() {
			try {
			//	Thread.sleep(5000);
				EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
				EntityManager entityManager = entityManagerFactory.createEntityManager();
				EntityTransaction tx = entityManager.getTransaction();
				tx.begin();
	
				Product p = entityManager.find(Product.class, 1);
				System.out.println("\tThread-2: Version " + p.getVersion() + " before update");
				
				System.out.println("\tlockmodetype is pessimistic force increment via test session2 ..before lock "+p.getVersion());
				entityManager.lock(p, LockModeType.PESSIMISTIC_FORCE_INCREMENT);
				System.out.println("\tlockmodetype is pessimistic force increment via test session2 ..after lock "+p.getVersion());
	
				Thread.sleep(1000);		
				p.setPrice(p.getPrice() + 10);
				
				
				//new lines
				//Product latestObject = entityManager.find(Product.class, p.getId());		
				//p.setVersion(latestObject.getVersion());
				
				
				
				tx.commit();
				entityManager.close();
				System.out.println("\tThread-2: Version " + p.getVersion() + " after update");
				//entityManagerFactory.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}