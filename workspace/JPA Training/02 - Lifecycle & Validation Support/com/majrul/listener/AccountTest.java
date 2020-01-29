package com.majrul.listener;

import org.junit.Test;

import com.majrul.util.BaseDao;

public class AccountTest {

	@Test
	public void testCase1() {
		Account account = new Account();
		account.setBalance(9000);
		
		new BaseDao().persist(account);
	}
	
}
