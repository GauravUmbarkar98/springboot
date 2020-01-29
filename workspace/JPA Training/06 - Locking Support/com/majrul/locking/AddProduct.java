package com.majrul.locking;

import org.junit.Test;

import com.majrul.util.BaseDao;

public class AddProduct {

	@Test
	public void add() {
		Product p = new Product("Nokia Handset",100);
		BaseDao dao = new BaseDao();
		dao.merge(p);
	}
}
