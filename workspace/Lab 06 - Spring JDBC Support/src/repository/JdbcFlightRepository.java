package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import entity.Flight;

public class JdbcFlightRepository implements FlightRepository {

	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int getTotalFlights() {
		return jdbcTemplate.queryForObject("select count(*) from flights_test", Integer.class);
	}
	
	public int getTotalFlights(String carrier) {
		return jdbcTemplate.queryForObject("select count(*) from flights_test where carrier = ?",
				new Object[]{carrier}, Integer.class);
	}
	
	public Map getFlightInfo(String flightNo) {
		return jdbcTemplate.queryForMap("select * from flights_test where flightno=?", flightNo);				
	}
	

	public List getFlights(String carrier) {
		return jdbcTemplate.queryForList("select * from flights_test where carrier = ?", carrier);
	}
	
	public List<Flight> getAvailableFlights(String carrier) {
		class FlightMapper implements RowMapper<Flight> {
			@Override
			public Flight mapRow(ResultSet rs, int index) throws SQLException {
				Flight flight = new Flight();
				flight.setFlightNo(rs.getString(1));
				flight.setCarrier(rs.getString(2));
				flight.setFrom(rs.getString(3));
				flight.setTo(rs.getString(4));
				return flight;
			}
		}
		return jdbcTemplate.query("select * from flights_test where carrier = ?", new FlightMapper(), carrier);
	}
	
	public void newFlight(Flight flight) {
		jdbcTemplate.update("insert into flights_test values(?, ?, ?, ?)", 
				flight.getFlightNo(), flight.getCarrier(), flight.getFrom(), flight.getTo());
	}
}
