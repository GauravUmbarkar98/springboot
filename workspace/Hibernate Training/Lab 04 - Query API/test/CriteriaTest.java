package test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.junit.Test;

import util.HibernateUtil;
import example.Item;

public class CriteriaTest {

	@Test
	public void testCriteria() {
		SessionFactory sessionFactory = 
				HibernateUtil.buildSessionFactory(Item.class);
		
		Session session = sessionFactory.openSession();

	    //"from Item where "+"name "+"like "+'S%'"
	   /* Criteria criteria = session.createCriteria(Item.class);
	    criteria.add(Restrictions.like( "name","S%"));
	    List<Criteria> list = criteria.list();
	    Iterator<Criteria> itr = list.iterator();
	    displayItem(itr);
	    */
		/*DetachedCriteria dc = DetachedCriteria.forClass(Item.class);
		...
		Criteria c = dc.getExecutableCriteria(session);*/
	    
	    Criteria criteria = session.createCriteria(Item.class);
	    criteria.add(Restrictions.in("name", new String[]{"MARUTI 800","SAHARA LAPTOP"}));
	    Disjunction subcriteria = Restrictions.disjunction();
	    subcriteria.add(Restrictions.gt("initialPrice", new Double(20000.0)));
	    subcriteria.add(Restrictions.lt("reservePrice", new Double(30000.0)));
	    criteria = criteria.add(subcriteria);
	    															    														
	    List list = criteria.list();
	    Iterator itr = list.iterator();
	    displayItem(itr);
	    
	    //from Item i join i.categories c where i.initialPrice > 100 and c.name like 'E%' 
	    /*Criteria criteria = session.createCriteria(Item.class);
	    criteria.add(Restrictions.gt("initialPrice", new Double(100.0)));
	    criteria.createCriteria("categories");
	    criteria.add(Restrictions.like("name","Laptop%"));
	    List list = criteria.list();
	    Iterator itr = list.iterator();
	    displayItem(itr);*/

		/*Criteria criteria = session.createCriteria(Item.class);
	    criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
	    Criteria subcriteria = criteria.createCriteria("bids", JoinType.LEFT_OUTER_JOIN);
	    subcriteria.add(Restrictions.ge("amount", 10000.0));
	    List list = criteria.list();
	    Iterator itr = list.iterator();
	    displayItem(itr);*/
	    
		/*Criteria criteria = session.createCriteria(Item.class);
		criteria.setProjection(Projections.rowCount()).add(Restrictions.ge("initialPrice", 1000.0));
		List results = criteria.list();
		System.out.println(results);*/
		
		/*Criteria criteria = session.createCriteria(Item.class);
		criteria.setProjection(Projections.projectionList()
				.add(Projections.property("name"))
				.add(Projections.property("initialPrice")));
		List results = criteria.list();
		Iterator itr = results.iterator();
		while(itr.hasNext()) {
			Object[] result = (Object[]) itr.next();
			System.out.println(Arrays.toString(result));
		}*/
	    
	    session.close();
	    sessionFactory.close();
	}
	
	private static void displayItem(Iterator itr) {
		while(itr.hasNext()) {
			Item item = (Item) itr.next();
			System.out.println(item);
			//System.out.println(item.getBids());			
		}
	}
}
