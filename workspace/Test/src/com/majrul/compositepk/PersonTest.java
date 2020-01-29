package com.majrul.compositepk;

import org.junit.Test;

import com.majrul.util.BaseDao;

public class PersonTest {

	@Test
	public void testCase1() {
		BaseDao dao = new BaseDao();
		Person p = new Person(new Person.Id("India",12345), "Majrul", 99);
		dao.merge(p);
	}
	
	@Test
	public void testCase2() {
		BaseDao dao = new BaseDao();
		Person p = dao.find(Person.class, new Person.Id("India", 12345));
		System.out.println(p);
	}
}
