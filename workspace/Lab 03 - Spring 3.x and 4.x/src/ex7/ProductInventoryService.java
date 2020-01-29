package ex7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductInventoryService {

	@Autowired
	public Dao<Product> productDao;
	
	public void addProduct(Product product) {
		productDao.add(product);
	}
	
	
}
