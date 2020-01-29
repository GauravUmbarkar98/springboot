package example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class LockingTest {

	static SessionFactory sessionFactory;

	static {
		sessionFactory = HibernateUtil.buildSessionFactory(Product.class);
	}

	public static void main(String[] args) {
		TestSession1 s1 = new TestSession1();
		TestSession2 s2 = new TestSession2();
		new Thread(s1).start();
		new Thread(s2).start();
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				sessionFactory.close();
			}
		});
	}

	static class TestSession1 implements Runnable {
	
		public void run() {
			try {
				Thread.sleep(1000);
				Session session = LockingTest.sessionFactory.getCurrentSession();
				Transaction tx = session.beginTransaction();
	
				Product p = (Product) session.get(Product.class, 1);
				System.out.println("Thread-1: Version " + p.getVersion() + " before update");
				/*LockRequest lockRequest = 
						session.buildLockRequest(new LockOptions(LockMode.PESSIMISTIC_FORCE_INCREMENT));
				lockRequest.lock(p);
				System.out.println("Thread-1: Version " + p.getVersion() + " after lock");*/
				
				p.setPrice(p.getPrice() + 10);
	
				tx.commit();
				System.out.println("Thread-1: Version " + p.getVersion() + " after update");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	static class TestSession2 implements Runnable {
	
		public void run() {
			try {
				Thread.sleep(500);
				Session session = LockingTest.sessionFactory.getCurrentSession();
				Transaction tx = session.beginTransaction();	
	
				Product p = (Product) session.get(Product.class, 1);
				System.out.println("Thread-2: Version " + p.getVersion() + " before update");
				/*LockRequest lockRequest = 
						session.buildLockRequest(new LockOptions(LockMode.PESSIMISTIC_FORCE_INCREMENT));
				lockRequest.lock(p);
				System.out.println("Thread-2: Version " + p.getVersion() + " after lock");*/
	
				Thread.sleep(1000);		
				
				p.setPrice(p.getPrice() + 10);
	
				tx.commit();
				System.out.println("Thread-2: Version " + p.getVersion() + " after update");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}