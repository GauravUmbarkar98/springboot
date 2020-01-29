package annotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import common.Flight;
import common.FlightRepository;

//TODO 4: Identify the correct annotation for automatically registering this class with the container
//by referring to slide no. 25

@Repository("flightRepo")
//@Named("flightRepo")
 
public class FlightRepositoryImpl implements FlightRepository {

	
	private DataSource dataSource;
	
	//TODO 2: Refer slide no. 22 to identify the annotation for injecting a DataSource
	
	//1
	@Resource(name="myds")
	
	//@Autowired		//2
	//@Qualifier("ds")
	
	//@Inject		//3
	//@Qualifier("ds")
	//@Named("ds")
	
	public void setDataSource(DataSource dataSource) {
		System.out.println("FlightRepositoryImpl: setDataSource() using @Resource Annotation....");
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
			try { rs.close(); pst.close(); conn.close(); } catch(Exception e) { }
		}
	}
}
