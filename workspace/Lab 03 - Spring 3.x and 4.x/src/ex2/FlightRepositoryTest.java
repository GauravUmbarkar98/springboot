package ex2;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FlightRepositoryTest {
	
	static {
		System.setProperty("spring.profiles.active", "prod");
	}

	@Test
	public void testErrorHandler() {
		ConfigurableApplicationContext container = new ClassPathXmlApplicationContext("ex2/ex2-config-1.xml");
		FlightRepository flightRepo = container.getBean("flightRepo2",FlightRepository.class);
		for(Flight flight : flightRepo.getAvailableFlights())
			System.out.println(flight);
	}
}
