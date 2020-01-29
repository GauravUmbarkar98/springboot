package ex7;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestClass {

	@Test
	public void test() {
		new AnnotationConfigApplicationContext(AppConfig.class);
	}
}
