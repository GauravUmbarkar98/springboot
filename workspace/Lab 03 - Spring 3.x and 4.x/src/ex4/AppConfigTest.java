package ex4;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppConfigTest {

	@Test
	public void testAppConfig() {
		 System.setProperty("spring.profiles.active", "dev");
		 ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		 FlightRepository flightRepo = (FlightRepository) ctx.getBean("flightRepo");
		 Assert.assertNotNull(flightRepo);
		 Assert.assertNotNull(flightRepo.getAvailableFlights());
	}
}
