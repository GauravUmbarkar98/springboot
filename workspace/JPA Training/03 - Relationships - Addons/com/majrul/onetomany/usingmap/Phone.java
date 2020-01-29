package com.majrul.onetomany.usingmap;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Phone4")
public class Phone implements Serializable {

    @Id
    @Column(name = "PHONE_ID")
    @GeneratedValue
    private int id;
    
    @Column(length=15)
    private String phoneNumber;

    // Bi-directional one-to-many relationship
    @ManyToOne(optional = false)
    private Employee employee;

    public Phone() {
    }

    public Phone(String phoneNumber, Employee emp) {
        this.phoneNumber = phoneNumber;
        this.employee = emp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

 
    public Phone(int id, String phoneNumber) {
        this.id = id;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
