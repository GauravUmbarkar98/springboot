package ex5;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestClass {

	@Test
	public void test() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ExampleBean exBean = ctx.getBean(ExampleBean.class);
		exBean.method();
	}
}
