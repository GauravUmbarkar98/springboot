package example;

import java.util.List;

import org.hibernate.Cache;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.stat.SecondLevelCacheStatistics;
import org.junit.Test;

import util.HibernateUtil;

public class StatisticsTest {

	@Test
	public void testCaching() throws Exception {
		SessionFactory sessionFactory = 
				HibernateUtil.buildSessionFactory(Cat.class);

		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List cats = session.createQuery("from Cat").
			setCacheable(true).list();
		tx.commit();

		SecondLevelCacheStatistics stats = sessionFactory.getStatistics().getSecondLevelCacheStatistics("example.Cat");
		System.out.println("No of objects in the cache : "+stats.getElementCountInMemory());
		System.out.println("Approx memory occupied : "+stats.getSizeInMemory());
		
		Cache slc = sessionFactory.getCache();
		slc.evictEntityRegion("example.Cat");

		stats = sessionFactory.getStatistics().getSecondLevelCacheStatistics("example.Cat");
		System.out.println("No of objects in the cache : "+stats.getElementCountInMemory());
		System.out.println("Approx memory occupied : "+stats.getSizeInMemory());

		sessionFactory.close();
	}
}
