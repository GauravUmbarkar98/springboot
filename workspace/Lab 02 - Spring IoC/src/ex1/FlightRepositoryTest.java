package ex1;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import common.Flight;
import common.FlightRepository;

//Use the same test class for testing different behavior by just changing the name of the xml file
public class FlightRepositoryTest {

	@Test
	public void testFlightRepo() {
		ApplicationContext container = new ClassPathXmlApplicationContext("ex1/ex1-config.xml");
		FlightRepository flightRepo =  container.getBean("flightRepo", FlightRepository.class);
		//FlightRepository flightRepo =  container.getBean("anno", FlightRepository.class);
		Assert.assertNotNull(flightRepo);
		List<Flight> flights = flightRepo.getAvailableFlights();
		Assert.assertTrue(flights.size() > 0);
		for(Flight flight : flights)
			System.out.println(flight);
		System.out.println("------------");
	}
}
