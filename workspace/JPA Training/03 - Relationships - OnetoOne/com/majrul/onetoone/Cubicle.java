package com.majrul.onetoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "Cubicle1")
public class Cubicle {

	@Id
	@GeneratedValue
	private int id;
	
	public String floor;
	
	//mappedBy specifies who owns the relationship
	@OneToOne(mappedBy = "assignedCubicle")
	private Employee residentEmployee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public Employee getResidentEmployee() {
		return residentEmployee;
	}

	public void setResidentEmployee(Employee residentEmployee) {
		this.residentEmployee = residentEmployee;
	}
	
	
	
}
