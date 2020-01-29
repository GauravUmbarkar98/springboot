/*
 * 		java technology
 * 				
 * 	---------------------------------------------
 * 	|					|			|
 * j2se					j2ee		j2me
 * |					1. Remote
 * core java			2. Time
 * lang fundas			3. Threading
 * exceptions			4. Caching
 * threading			5. Pooling
 * file io				6. Transaction
 * generics				7. Security
 * collections
 * swings						EJB	
 * jdbc							|
 * |				----------------------------
 * adv java				|			|		|
 * |					session		entity	message
 * socket programming		|			|
 * rmi				-------------		-----------------
 * 					|			|			|		|
 * 				stateless		statefull	cmp		bmp
 * 					|			|
 * 		getAvailableFlights()	getTicket();
 * 				
 * 
 * 
 * 
 */


package hibernate.onetomanybi;

import java.util.HashSet;
import java.util.Set;

public class Department {

	private int deptno;
	private String name;
	private String location;
	private Set<Employee> employees = new HashSet<Employee>();

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
