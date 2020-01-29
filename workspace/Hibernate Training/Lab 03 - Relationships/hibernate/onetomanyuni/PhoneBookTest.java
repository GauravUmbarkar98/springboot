/*
 *  interface WithdrawService
 *      withdraw();
 *      
 *      
 *   interface DepositService
 *   	deposit();
 *   
 *   
 *   
 *   SavingsAccount  implements WithdrawService,WithdrawService
 *   		withdraw();
 *   		deposit();
 *   
 *   
 * SavingsAccount  s1;
 * 
 * SavingsAccount  t1;
 * 
 * class Services
 * {
 * 
 *   fundTransfer(WithdrawService  x,  DepositService  Y)
 *   {
 *   	x.withdraw();
 *   	y.deposit();
 *   }
 *   
 *   
 * }
 * 
 * 
 * 
 */



package hibernate.onetomanyuni;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import util.HibernateUtil;

public class PhoneBookTest {

	@Test
	public void testCase1() {
		SessionFactory sessionFactory = 
				HibernateUtil.buildSessionFactory(PhoneBook.class);
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		PhoneBook phBook = new PhoneBook();
		phBook.setName("My PhoneBook");
		
		Set<Entry> entries = new HashSet<Entry>();
		entries.add(new Entry("Entry1", 12345, "entry1@domain.com"));
		entries.add(new Entry("Entry2", 12345, "entry1@domain.com"));
		entries.add(new Entry("Entry3", 12345, "entry1@domain.com"));
		entries.add(new Entry("Entry4", 12345, "entry1@domain.com"));
		entries.add(new Entry("Entry5", 12345, "entry1@domain.com"));
		phBook.setEntries(entries);
		
		session.save(phBook);
		tx.commit();

		sessionFactory.close();
	}
	
	@Test
	public void testCase2() {
		SessionFactory sessionFactory = 
				HibernateUtil.buildSessionFactory(PhoneBook.class);
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		PhoneBook phBook = (PhoneBook) session.get(PhoneBook.class, 1);
		System.out.println(phBook);
		System.out.println(phBook.getEntries());
		
		tx.commit();
	
		sessionFactory.close();
	}

	@Test
	public void testCase3() {
		Entry newEntry = new Entry("New Entry", 12345, "newentry@domain.com");
		
		SessionFactory sessionFactory = 
				HibernateUtil.buildSessionFactory(PhoneBook.class);
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		PhoneBook phBook = (PhoneBook) session.get(PhoneBook.class, 1);
		phBook.getEntries().add(newEntry);
		
		tx.commit();

		sessionFactory.close();
	}

	/*
	 * Adding an Entry to the PhoneBook after it has been detached.
	 * 
	 */
	@Test
	public void testCase4() {
		Entry newEntry = new Entry("New Entry", 92345, "newentry@domain.com");
		
		SessionFactory sessionFactory = 
				HibernateUtil.buildSessionFactory(PhoneBook.class);
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		PhoneBook phBook = (PhoneBook) session.get(PhoneBook.class, 1);
		//tx.commit();
		//By now the PhoneBook object is detached
		
		phBook.getEntries().add(newEntry);
		
		//session = sessionFactory.getCurrentSession();
		//tx = session.beginTransaction();
		session.update(phBook);
		tx.commit();

		sessionFactory.close();
	}

	@Test
	public void testCase5() {
		SessionFactory sessionFactory = 
				HibernateUtil.buildSessionFactory(PhoneBook.class);
		
		Session session = sessionFactory.getCurrentSession();
		System.out.println("got the session..");
		Transaction tx = session.beginTransaction();
		
		PhoneBook phBook = (PhoneBook) session.get(PhoneBook.class, 1);
		
		Iterator<Entry> itr = phBook.getEntries().iterator();
		while(itr.hasNext()) {
			
			
			Entry entry = itr.next();
			System.out.println("data ..."+entry);
			if(entry.getName().equals("New Entry")) {
				itr.remove(); //the removed child is now orphan
					System.out.println("removed...from iteration");
					
			}
		}
	
		tx.commit();

		sessionFactory.close();
	}
}
