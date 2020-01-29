package com.majrul.onetomanyuni;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.majrul.util.BaseDao;

public class PhoneBookTest {

	@Test
	public void testCase1() {
		PhoneBook phBook = new PhoneBook();
		phBook.setName("My PhoneBook");
		
		Set<Entry> entries = new HashSet<Entry>();
		entries.add(new Entry("Entry1", 12345, "entry1@domain.com"));
		entries.add(new Entry("Entry2", 12345, "entry1@domain.com"));
		entries.add(new Entry("Entry3", 12345, "entry1@domain.com"));
		entries.add(new Entry("Entry4", 12345, "entry1@domain.com"));
		entries.add(new Entry("Entry5", 12345, "entry1@domain.com"));
		phBook.setEntries(entries);
		
		BaseDao dao = new BaseDao();
		dao.merge(phBook);
	}
	
	@Test
	public void testCase2() {
		BaseDao dao = new BaseDao();
		PhoneBook phBook = (PhoneBook) dao.find(PhoneBook.class, 1);
		System.out.println(phBook);
		System.out.println(phBook.getEntries());
	}

	@Test
	public void testCase3() {
		BaseDao dao = new BaseDao();		
		Entry newEntry = new Entry("New Entry", 12345, "newentry@domain.com");
		PhoneBook phBook = (PhoneBook) dao.find(PhoneBook.class, 1);
		phBook.getEntries().add(newEntry);
		dao.merge(phBook);
	}

}
