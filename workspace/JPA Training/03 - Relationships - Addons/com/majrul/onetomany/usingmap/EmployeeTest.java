package com.majrul.onetomany.usingmap;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.majrul.util.BaseDao;

public class EmployeeTest {

    @Test
    public void add() {

        Employee emp = new Employee();
        emp.setName("Bill Gates");
        emp.setSalary(100000);
        
        Map<String, Phone> phones = new HashMap<String, Phone>();
        phones.put("cell", new Phone("111-111-1234", emp));
        phones.put("home", new Phone("111-111-2345", emp));
        phones.put("fax", new Phone("111-111-2341", emp));
        phones.put("cell2", new Phone("111-111-3455", emp));
        
        emp.setPhones(phones);
        
        new BaseDao().persist(emp);
    }

}
