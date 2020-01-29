package com.majrul.onetomany.usinglist;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.majrul.util.BaseDao;

public class AddEmployeeTest {

	@Test
	public void add() {
		Employee employee = new Employee();
		employee.setName("Bill Gates");
		List<Phone> phones = new ArrayList<Phone>();
        phones.add(new Phone("111-111-1234"));
        phones.add(new Phone("111-111-2345"));
        phones.add(new Phone("111-111-2341"));
        phones.add(new Phone("111-111-3455"));
        employee.setPhones(phones);

        new BaseDao().persist(employee);
	}
	@Test
	public void remove() {
		BaseDao base = new BaseDao();
		
		Employee employee = base.getReference(Employee.class,11);
		/*System.out.println("id  :"+employee.getId());
		System.out.println("name:"+employee.getName());
		System.out.println("sal :"+employee.getSalary());*/
		
		
		base.remove(employee);
		
      
	}
	
}
