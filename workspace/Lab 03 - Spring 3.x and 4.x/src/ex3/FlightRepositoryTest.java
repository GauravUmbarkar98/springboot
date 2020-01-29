package ex3;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FlightRepositoryTest {
	
	@Test
	public void testCaching() {
		ConfigurableApplicationContext container = new ClassPathXmlApplicationContext(
				"ex3/ex3-config-1.xml");
		FlightRepository flightRepo = container.getBean(FlightRepository.class);
		System.out.println(flightRepo.getClass());

		System.out.println("===============getAvailableFlights() Call 1==============================");
		for(Flight flight : flightRepo.getAvailableFlights())
			System.out.println(flight);		

		System.out.println("===============getAvailableFlights() Call 2==============================");
		for(Flight flight : flightRepo.getAvailableFlights())
			System.out.println(flight);		

		System.out.println("===============getAvailableFlights(carrier) Call 1==============================");
		for(Flight flight : flightRepo.getAvailableFlights("JET"))
			System.out.println(flight);		

		System.out.println("===============getAvailableFlights(carrier) Call 2==============================");
		for(Flight flight : flightRepo.getAvailableFlights("JET"))
			System.out.println(flight);		

		System.out.println("===============getAvailableFlights(carrier) Call 3==============================");
		for(Flight flight : flightRepo.getAvailableFlights("GO"))
			System.out.println(flight);		

		System.out.println("===============getAvailableFlights(carrier) Call 4==============================");
		for(Flight flight : flightRepo.getAvailableFlights("GO"))
			System.out.println(flight);		

		System.out.println("===============addNewFlight(Flight)==============================");		
		Flight fl = new Flight();
		fl.setFlightNo("JL-137");
		fl.setFrom("GOA");
		fl.setTo("MUMBAI");
		fl.setCarrier("JET AIRWAYS");
		flightRepo.addNewFlight(fl);
		System.out.println("===============after addNewFlight(Flight)==============================");		

		System.out.println("===============getAvailableFlights()==============================");
		for(Flight flight : flightRepo.getAvailableFlights())
			System.out.println(flight);		

		System.out.println("===============getAvailableFlights(carrier)==============================");
		for(Flight flight : flightRepo.getAvailableFlights("JET"))
			System.out.println(flight);		
		
	}
}
