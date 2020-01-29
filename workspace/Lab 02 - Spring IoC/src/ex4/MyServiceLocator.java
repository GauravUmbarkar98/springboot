package ex4;

import org.springframework.beans.factory.FactoryBean;

public class MyServiceLocator implements FactoryBean<MyService> {

	public MyServiceLocator()
	{
		System.out.println("MyServiceLocator ctor...");
	}
	@Override
	public MyService getObject() throws Exception {
		System.out.println("MyService getObject() invoked...");
		
		
		return new MyService();
	}

	@Override
	public Class<?> getObjectType() {
		System.out.println("Class<?> getObjectType() invoked...");
		return MyService.class;
	}

	@Override
	public boolean isSingleton() {
		System.out.println("isSingleton() invoked...");
		return false;
	}	
}
