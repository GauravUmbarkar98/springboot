package repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class JdbcProductRepository  implements ProductRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional()
	public void reduceStock(int productId, int quantity) {
		String sql = "update tx_products set quantity = quantity - ? where productid = ?";
		//very bad log
		System.out.println("JDBC: "+sql);
		jdbcTemplate.update(sql, quantity, productId);
	}
}
