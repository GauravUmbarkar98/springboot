package com.majrul.embedded;

import org.junit.Test;

import com.majrul.util.BaseDao;

public class UserTest {

	@Test
	public void testCase1() { 
		User  u = new User();
		u.setId(88);
		u.setFirstname("Majrul");
		u.setLastname("Ansari");
		u.setUsername("majrul");
		u.setPassword("majrul123");
		
		Address officeAddress = new Address();
		officeAddress.setCity("Mumbai1");
		officeAddress.setStreet("Vikhroli");
		officeAddress.setZipcode("400083");
		
		Address homeAddress = new Address();
		homeAddress.setCity("Pune2");
		homeAddress.setStreet("LAxmi Road");
		homeAddress.setZipcode("411083");

		u.setBillingAddress(officeAddress);
		u.setHomeAddress(homeAddress);

		BaseDao dao = new BaseDao();
		dao.merge(u);
	}
}
