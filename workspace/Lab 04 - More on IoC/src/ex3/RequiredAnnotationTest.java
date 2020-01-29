package ex3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RequiredAnnotationTest {

	@Test
	public void testConfig() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ex3/ex3-config.xml");
	}
}
