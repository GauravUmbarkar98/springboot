package test;

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
		//ApplicationContext container = new ClassPathXmlApplicationContext("xml-config-3.xml");
		ApplicationContext container = new ClassPathXmlApplicationContext("annotations-config-3.xml");
		
		FlightRepository flightRepo = (FlightRepository) container.getBean("flightRepo1");
		
		Assert.assertNotNull(flightRepo);
		
		List<Flight> flights = flightRepo.getAvailableFlights();
		
		Assert.assertTrue(flights.size() > 0);
		
		for(Flight flight : flights)
			System.out.println(flight);
	}
}
   