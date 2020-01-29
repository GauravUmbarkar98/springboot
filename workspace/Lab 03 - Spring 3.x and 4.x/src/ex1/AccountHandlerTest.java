package ex1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountHandlerTest {

	@Test
	public void testErrorHandler() {
		ApplicationContext container = new ClassPathXmlApplicationContext("ex1/account-config-1.xml");
		CurrentAccount cur = container.getBean(CurrentAccount.class);
		
		cur.deposit();
		
		//sav.withdraw(8000);
	}
}
