package ex8;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ClassB {

	public ClassB() {
		System.out.println("Constructor of ClassB()");
	}
	
	public void someOtherMethod() {
		
	}
}
