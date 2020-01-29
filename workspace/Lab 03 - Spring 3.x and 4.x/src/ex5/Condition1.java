package ex5;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class Condition1 implements Condition {

	@Override
	public boolean matches(ConditionContext condition, AnnotatedTypeMetadata metadata) {
		return condition.getEnvironment().getProperty("user.country").equals("US");
	}
	
}
