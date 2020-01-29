package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import entity.Flight;
import repository.FlightRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:ex-config.xml")
public class FlightRepositoryTest {

	@Autowired private FlightRepository flightRepository;
	
	@Test
	public void testDifferentMethods() {
		System.out.println(flightRepository.getTotalFlights());
		System.out.println(flightRepository.getTotalFlights("KINGFISHER"));
		System.out.println(flightRepository.getFlightInfo("JL-120"));
		System.out.println(flightRepository.getFlights("KINGFISHER"));
		System.out.println(flightRepository.getAvailableFlights("KINGFISHER"));
		
		List<Flight> l = flightRepository.getAvailableFlights("GO AIR");
		for (Flight fl : l) {
			System.out.println("fl "+fl);
		}
		
	}	
}
