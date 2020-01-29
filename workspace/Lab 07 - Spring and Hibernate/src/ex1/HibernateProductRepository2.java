package ex1;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

//Using HibernateTemplate, don't use this approach anymore
@Transactional
public class HibernateProductRepository2 implements ProductRepository {

	private HibernateTemplate hibernateTemplate;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	@Override
	public void add(Product product) {
		hibernateTemplate.save(product);		
	}

	@Override
	public Product get(int productId) {
		Product product = (Product) hibernateTemplate.get(Product.class, productId);
		return product;
	}

	@Override
	public List<Product> getAll() {
		List<Product> products = (List<Product>) hibernateTemplate.find("from Product");
		return products;
	}

}
