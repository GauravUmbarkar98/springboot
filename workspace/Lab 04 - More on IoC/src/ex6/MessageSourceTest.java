package ex6;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageSourceTest {

	@Test
	public void testI18n() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ex6/ex6-config.xml");
		OrderProcessingService orderProcessing = ctx.getBean(OrderProcessingService.class);
		try {
			orderProcessing.placeOrder(5);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
