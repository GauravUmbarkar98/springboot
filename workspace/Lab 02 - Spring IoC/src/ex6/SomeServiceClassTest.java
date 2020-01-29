package ex6;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SomeServiceClassTest {

	@Test
	public void testSomeServiceClass() {
		ApplicationContext container = new ClassPathXmlApplicationContext("ex6/ex6-config-1.xml");	
		//You will find 3 entries of CustomerService in the xml file, so test all 3 implementations one by one
		SomeServiceClass serviceClass = (SomeServiceClass) container.getBean("serviceClass", SomeServiceClass.class);
		Assert.assertNotNull(serviceClass);	
		//testing whether the properties was injected correctly
		Assert.assertNotNull(serviceClass.getAdminEmails());
	}
}
