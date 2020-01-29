package test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.transform.Transformers;
import org.junit.Test;

import util.HibernateUtil;

import example.Item;
import example.ItemInfo;
import example.OldItem;

public class SQLTest {

	@Test
	public void testQueries() throws Exception {
		SessionFactory sessionFactory = 
				HibernateUtil.buildSessionFactory(Item.class, OldItem.class);
		
	    Session session = sessionFactory.getCurrentSession();
	    Transaction tx = session.beginTransaction();

	    /*List list = session.createSQLQuery("select * from items").list();
	    Iterator itr = list.iterator();
	    while(itr.hasNext()) {
	    		Object[] arr = (Object[]) itr.next();
	    		for(int i=0;i<arr.length;i++)
	    			System.out.print(arr[i]+"\t");
	    		System.out.println();
	    }*/
	    
	    List<Item> list = session.createSQLQuery("select * from items").addEntity(Item.class).list();
	    for(Item item : list)
	    		System.out.println(item);
	    
	    /*List<ItemInfo> list = session.createSQLQuery("select i.item_id as id, i.name as name from items i")
	    										.setResultTransformer(Transformers.aliasToBean(ItemInfo.class)).list();
	    for(ItemInfo item : list)
	    		System.out.println(item);*/
	    
	    /*List<Item> list = session.getNamedQuery("example.items.findAll").setParameter(0, 1).list();
	    for(Item item : list)
	    		System.out.println(item);*/	    

	    tx.commit();

		sessionFactory.close();
	}
	
}
