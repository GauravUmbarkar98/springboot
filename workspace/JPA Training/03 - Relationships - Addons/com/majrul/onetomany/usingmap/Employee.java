package com.majrul.onetomany.usingmap;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;

@Entity(name = "Employee4")
public class Employee implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "EMPLOYEE_ID",length=3)
    private int eid;

    @Column(length=20)
    private String name;
    private long salary;

    // Bidirectional one to many relationship through "mappedBy".
    // The value of "mappedBy" is a field of Phone entity class.
    @OneToMany(cascade=CascadeType.ALL, mappedBy="employee")
    // The @MapKeyColumn annotation is used to define a map
    //@MapKeyColumn(name="PHONE_TYPE")
    @Column(length=10)
    private Map<String, Phone> phones;

    public Employee() {
    }

    public Employee(int id) {
        this.eid = id;
    }

    public int getId() {
        return eid;
    }

    public void setId(int id) {
        this.eid = id;
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

    public Map<String, Phone> getPhones() {
        return phones;
    }

    public void setPhones(Map<String, Phone> phones) {
        this.phones = phones;
    }

}
