package com.majrul.onetoone;

import org.junit.Test;

import com.majrul.util.BaseDao;

public class EmployeeCubicleTest {

	@Test
	public void addEmp() {
		Employee emp = new Employee();
		emp.setName("Majrul");
		
		new BaseDao().persist(emp);
	}
	
	@Test
	public void addCubicle() {
		Cubicle cub = new Cubicle();
		cub.setFloor("6th Floor");
		
		new BaseDao().persist(cub);
	}
	
	@Test
	public void addEmployeeAlongWithCubicle() {
		Employee emp = new Employee();
		emp.setName("James");
		Cubicle cubicle = new Cubicle();
		cubicle.setFloor("5th Floor");
		emp.setAssignedCubicle(cubicle);
		
		new BaseDao().persist(emp);
		
	}
	
	@Test
	public void assignCubicleToEmployee() {
		BaseDao dao = new BaseDao();
		
		Employee emp = dao.find(Employee.class, 1);
		Cubicle cubicle = dao.find(Cubicle.class, 1);
		emp.setAssignedCubicle(cubicle);		
		dao.merge(emp);
	}
}
