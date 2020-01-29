package com.majrul.onetomany.usingmap;

import java.util.Collection;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.majrul.util.BaseDao;

public class EmployeeService {

    protected EntityManager em;

    public EmployeeService(EntityManager em) {
        this.em = em;
    }

    public Employee createEmployee(String name, long salary) {
        Employee emp = new Employee();
        emp.setName(name);
        emp.setSalary(salary);
        em.persist(emp);
        return emp;
    }

    public Employee updateEmployee(Employee emp) {
        em.persist(emp);
        return emp;
    }

    public void setPhones(Employee emp, Map<String, Phone> phones) {
        if (emp != null) {
            emp.setPhones(phones);
        }
    }

    public void removeEmployee(int id) {
        Employee emp = findEmployee(id);
        if (emp != null) {
            em.remove(emp);
        }
    }

    public Employee raiseEmployeeSalary(int id, long raise) {
        Employee emp = em.find(Employee.class, id);
        if (emp != null) {
            emp.setSalary(emp.getSalary() + raise);
        }
        return emp;
    }

    public Employee findEmployee(int id) {
        return em.find(Employee.class, id);
    }

    public Collection<Employee> findAllEmployees() {
        Query query = em.createQuery("SELECT e FROM Employee e");
        return (Collection<Employee>) query.getResultList();
    }
    public static void main(String[] args) {
		BaseDao base = new BaseDao();
		EntityManager em = base.getEntityManager();
		EmployeeService empService = new EmployeeService(em);
		Employee e = empService.createEmployee("jack",5000);
		System.out.println("e "+e.getName() + " sal "+e.getSalary());
	}
}
