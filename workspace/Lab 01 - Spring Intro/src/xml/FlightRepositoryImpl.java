package xml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import common.Flight;
import common.FlightRepository;


/* 
 * IQ  FIQ  EmotionsIQ   SIQ
 * 
 * richdad.com
 * 	rich dad vs poor dad
 * Robert Kiyosaki
 * H
 * P
 * S
 * ES
 * MCAS
 * BBA
 * CDAC
 * 		
 * Employee
 * |
 * E   |	B (Atos)<--->B(Pampers) <---- Business
 * -----------
 * S   |    I <-- Very Large Scale Investor
 * |
 * self
 * employed
 * 
 */

// FlightRepositoryImpl  f = container.getBean("flirepo");

// DataSource ds= new Spring-->DriverManagerDataSource();
// ds.setDriver..
// ds.setUrl
// ds.setuser..
// ds.setpass
// f.setDataSource(ds);

public class FlightRepositoryImpl implements FlightRepository {

	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		System.out.println("setDateSource(DataSource) setter method invoked...");
		this.dataSource = dataSource;
	}

	public List<Flight> getAvailableFlights() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			String sql = "select * from flights_test";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			List<Flight> rows = new ArrayList<Flight>();
			while(rs.next()) {
				Flight f = new Flight();
				f.setFlightNo(rs.getString(1));
				f.setCarrier(rs.getString(2));
				f.setFrom(rs.getString(3));
				f.setTo(rs.getString(4));
				rows.add(f);
			}
			return rows;
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
		finally {
			try { rs.close(); pst.close(); conn.close(); } catch(Exception e) { 
				
				System.out.println("error "+e);
			}
		}
	}
}
