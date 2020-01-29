package com.majrul.validation;

import java.util.Date;

import org.junit.Test;

import com.majrul.util.BaseDao;

public class CDTest {

	@Test
	public void testValidation() {
		CD cd = new CD("ST", "Some Artist's Lengthy Name", new Date(), 9.99);
		
		BaseDao dao = new BaseDao();
		dao.merge(cd);
	}
}
