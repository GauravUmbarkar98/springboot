package ex1;

import java.util.ArrayList;
import java.util.List;

public class ProductList {

	private List<Product> products;
	
	public ProductList() {
		products = new ArrayList<Product>();
		products.add(new Product("Nokia 6600", 4500));
		products.add(new Product("Samsung Galaxy", 9500));
		products.add(new Product("Nokia Lumia", 17500));
		products.add(new Product("Samsung Galaxy S2", 19500));
	}

	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
