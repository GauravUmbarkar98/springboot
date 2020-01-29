package ex3;

import java.util.List;

public interface FlightRepository {

	public List<Flight> getAvailableFlights();
	public List<Flight> getAvailableFlights(String carrier);
	public void addNewFlight(Flight flight);

}
