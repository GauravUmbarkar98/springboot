package ex5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan("ex5")
public class AppConfig {

	@Bean
	@Conditional(Condition1.class)
	public PropertySourcesPlaceholderConfigurer placeholderConfigurer1() {
		PropertySourcesPlaceholderConfigurer props = new PropertySourcesPlaceholderConfigurer();
		props.setLocation(new ClassPathResource("ex5/messages1.properties"));
		return props;
	}

	@Bean
	@Conditional(Condition2.class)
	public PropertySourcesPlaceholderConfigurer placeholderConfigurer2() {
		PropertySourcesPlaceholderConfigurer props = new PropertySourcesPlaceholderConfigurer();
		props.setLocation(new ClassPathResource("ex5/messages2.properties"));
		return props;
	}
}
