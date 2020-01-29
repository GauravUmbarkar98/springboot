package ex3;

import javax.sql.DataSource;

public class MyServiceLocator {

	public MyService createMyService() {
		//we assume there is some complex code to initialize MyService bean
		System.out.println("createMyService()");
		return new MyService();
	}
	
	public MyService createMyService(DataSource dataSource) {
		//some database specific code to fetch values required for instantiating the bean
		System.out.println("createMyService(DataSource)");
		return new MyService();
	}

	public MyService createMyService(String someParameter) {
		//some database specific code to fetch values required for instantiating the bean
		System.out.println("createMyService(String)");
		System.out.println("Just checking "+someParameter);
		return new MyService();
	}

}
