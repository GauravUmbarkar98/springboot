package com.majrul.elementcollection;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.majrul.util.BaseDao;

public class ProductTest {

	@Test
	public void addProduct() {
		Product product = new Product();
		product.setName("Nokia 6600");
		product.setPrice(4500.0);
		
		BaseDao dao = new BaseDao();
		dao.persist(product);
	}

	@Test
	public void addProductWithTags() {
		Product product = new Product();
		product.setName("Nokia 6600");
		product.setPrice(4500.0);
		
		Set<String> tags = new HashSet<String>();
		tags.add("Mobile phone");
		tags.add("Nokia");
		product.setTags(tags);
		
		BaseDao dao = new BaseDao();
		dao.persist(product);
	}

	@Test
	public void getProduct() {
		BaseDao dao = new BaseDao();
		
		Product product = dao.find(Product.class, 1);
		System.out.println(product.getName() + "\t" + product.getPrice());
		
	}
}
