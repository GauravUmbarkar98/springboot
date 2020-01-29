package com.majrul.onetomany.usinglist;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity(name = "Employee3")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "EMPLOYEE_ID")
    private int id;

    @Column(length=20)
    private String name;
    private long salary;

    // Unidirectional One-to-Many association using a foreign key mapping
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
    // The join column is in table for Phone (for Unidirectional relationship)
    // Should be mentioned on the @ManyToOne end generally
    @JoinColumn(name="EMPLOYEE_ID_FK") 
    // Specifies a column that is used to maintain the persistent order of a list.
    //@OrderColumn(name = "PHONE_ENTRY_ORDER")
    private List<Phone> phones;

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

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

    
}