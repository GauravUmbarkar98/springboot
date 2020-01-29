package com.majrul.onetoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "Employee1")
public class Employee {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	//default lazy behavior : eager
	@OneToOne
	@JoinColumn(name = "cubicle_id_fk")
	private Cubicle assignedCubicle;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cubicle getAssignedCubicle() {
		return assignedCubicle;
	}

	public void setAssignedCubicle(Cubicle assignedCubicle) {
		this.assignedCubicle = assignedCubicle;
	}
	
	
}
