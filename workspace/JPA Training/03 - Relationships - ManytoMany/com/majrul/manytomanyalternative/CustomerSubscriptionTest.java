package com.majrul.manytomanyalternative;

import java.util.Date;

import org.junit.Test;

import com.majrul.util.BaseDao;

public class CustomerSubscriptionTest {

	@Test
	public void testCase1() {
		BaseDao dao = new BaseDao();
		
		Customer cust = new Customer();
		cust.setName("Majrul"); cust.setEmail("majrul@gmail.com");
		dao.merge(cust);
		cust = new Customer();
		cust.setName("Bill"); cust.setEmail("bill@gates.com");
		dao.merge(cust);
		
		Subscription subs = new Subscription();
		subs.setType("Book"); subs.setDuration(2);
		dao.merge(subs);
		subs = new Subscription();
		subs.setType("DVD"); subs.setDuration(3);
		dao.merge(subs);
	}
	
	@Test
	public void testCase2() {
		BaseDao dao = new BaseDao();
		
		CustomerSubscriptionLink custsub = new CustomerSubscriptionLink();
		custsub.setCustomer(dao.find(Customer.class, 1));
		custsub.setSubscription(dao.find(Subscription.class, 2));
		custsub.setSubscriptionDate(new Date());
		dao.merge(custsub);
	}
}
