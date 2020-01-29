package com.majrul.onetomanybi;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.majrul.util.BaseDao;

public class AddEmpDeptTest {

	@Test
	public void testCase1a()
	{
		Department dept1 = new Department(10,"Admin","Andheri");
		
		Set<Employee> emps = new HashSet<Employee>();
		
		emps.add(new Employee(1010,"Emp1",1000,dept1));
		emps.add(new Employee(1011,"Emp2",2000,dept1));
		emps.add(new Employee(1012,"Emp3",3000,dept1));
		
		dept1.setEmployees(emps);
		
		
		Department dept2 = new Department(20,"HR","Vashi");
		
		emps = new HashSet<Employee>();
		
		emps.add(new Employee(2010,"Emp1",1000,dept2));
		emps.add(new Employee(2011,"Emp2",2000,dept2));
		emps.add(new Employee(2012,"Emp3",3000,dept1));
		
		dept2.setEmployees(emps);
		
		BaseDao dao = new BaseDao();
		dao.persist(dept1);
		dao.persist(dept2);
		
		
	}
	@Test
	public void testCase1() {
		
		Department dept = new Department();
		dept.setDeptno(10);
		dept.setName("Admin");
		dept.setLocation("Andheri, Mumbai");

		BaseDao dao = new BaseDao();
		dao.merge(dept);
	}

	@Test
	public void testCase2() {
		BaseDao dao = new BaseDao();

		Department dept = (Department) dao.getReference(Department.class, 10);
		Employee emp = new Employee();
		emp.setEmpno(1002);
		emp.setName("Majrul Ansari2");
		emp.setSalary(1002.0);
		emp.setDept(dept);
		
		dao.persist(emp);
	}
	
	@Test
	public void testCase3() {
		BaseDao dao = new BaseDao();
		Department dept = (Department) dao.find(Department.class, 10);
	}
}





