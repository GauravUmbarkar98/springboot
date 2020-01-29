package hibernate.onetomanybi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import util.HibernateUtil;

public class DeptEmpTest {

	@Test
	public void testCase1() {
		SessionFactory sessionFactory = 
				HibernateUtil.buildSessionFactory(Employee.class);
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Department dept = new Department();
		dept.setDeptno(10);
		dept.setName("Admin");
		dept.setLocation("Andheri, Mumbai");
		
		session.save(dept);
		tx.commit();
		
		sessionFactory.close();
	}

	@Test
	public void testCase2() {
		SessionFactory sessionFactory = 
				HibernateUtil.buildSessionFactory(Employee.class);
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Department dept = (Department) session.get(Department.class, 10);
		
		Employee emp = new Employee();
		emp.setEmpno(1002);
		emp.setName("Vishal Dawane");
		emp.setSalary(2000.0);
		emp.setDept(dept);
		
		session.save(emp);
		tx.commit();

		sessionFactory.close();
	}
}





