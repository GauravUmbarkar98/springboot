package ex3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

public class FlightRepositoryImpl implements FlightRepository {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Cacheable("allflights")
	public List<Flight> getAvailableFlights() {
		System.out.println("getAvailableFlights called..Accessing the DB");
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "select * from flights_test";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			List<Flight> rows = new ArrayList<Flight>();
			while (rs.next()) {
				Flight f = new Flight();
				f.setFlightNo(rs.getString(1));
				f.setCarrier(rs.getString(2));
				f.setFrom(rs.getString(3));
				f.setTo(rs.getString(4));
				rows.add(f);
			}
			return rows;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (Exception e) {
			}
		}
	}
	
	@Cacheable(value = "carrierflights", condition = "#carrier.startsWith('JET')")
	public List<Flight> getAvailableFlights(String carrier) {
		System.out.println("getAvailableFlights called..Accessing the DB");
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "select * from flights_test where carrier like ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, carrier + "%");
			rs = pst.executeQuery();
			List<Flight> rows = new ArrayList<Flight>();
			while (rs.next()) {
				Flight f = new Flight();
				f.setFlightNo(rs.getString(1));
				f.setCarrier(rs.getString(2));
				f.setFrom(rs.getString(3));
				f.setTo(rs.getString(4));
				rows.add(f);
			}
			return rows;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (Exception e) {
			}
		}
	}

	@CacheEvict(value = {"allflights","carrierflights"}, allEntries = true)
	public void addNewFlight(Flight flight) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = dataSource.getConnection();
			String sql = "insert into flights_test values(?, ?, ?, ?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, flight.getFlightNo());
			pst.setString(2, flight.getCarrier());
			pst.setString(3, flight.getFrom());
			pst.setString(4, flight.getTo());
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (Exception e) {
			}
		}
		
	}

}
