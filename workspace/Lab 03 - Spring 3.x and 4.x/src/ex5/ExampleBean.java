package ex5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExampleBean {

	@Value("${message}")
	private String message;
	
	public void method() {
		System.out.println(message);
	}
}
