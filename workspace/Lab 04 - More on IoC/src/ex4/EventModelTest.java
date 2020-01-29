package ex4;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EventModelTest {

	@Test
	public void testCustomEvent() {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("ex4/ex4-config.xml");
		EmailBean emailer = ctx.getBean(EmailBean.class);
		//sending an email to a blacklisted id so that an event can be raised
		emailer.sendEmail("john@doe.org", "hello");
		ctx.close();
	}
}
