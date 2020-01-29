package com.majrul.caching;

import org.junit.Test;

import com.majrul.util.BaseDao;

public class AddSomeFlights {

	@Test
	public void add() {
		BaseDao dao = new BaseDao();
		
		Flight flight = new Flight("AI-123", "Air India", "Mumbai", "Delhi");
		dao.persist(flight);
		flight = new Flight("GO-456", "Go Air", "Bangalore", "Chennai");
		dao.persist(flight);
	}
}
