package com.majrul.onetomanybi;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.eclipse.persistence.jpa.config.Cascade;

@Entity(name = "Department2")
public class Department {

	@Id private int deptno;
	@Column private String name;
	@Column private String location;
	
	@OneToMany(mappedBy="dept",cascade=CascadeType.ALL)
	@OrderBy("name asc")
	private Set<Employee> employees;
	
	
	public Department(int deptno, String name, String location) {
		super();
		this.deptno = deptno;
		this.name = name;
		this.location = location;
	}
	public Department() {
		super();
	}
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
