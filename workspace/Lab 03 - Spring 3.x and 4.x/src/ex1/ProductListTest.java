package ex1;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class ProductListTest {

	@Test
	public void testErrorHandler() {
		ApplicationContext container = new ClassPathXmlApplicationContext("ex1/ex1-config-4.xml");
		
		ProductList productList = container.getBean(ProductList.class);

		//Using Spring EL API
		ExpressionParser parser = new SpelExpressionParser();
		List<Product> products = (List<Product>) parser.parseExpression("products.?[name.startsWith('Nokia')]").getValue(productList);
		System.out.println(products);
		
		List<String> productNames = (List<String>) parser.parseExpression("products.![name]").getValue(productList);
		System.out.println(productNames);
	}
}
