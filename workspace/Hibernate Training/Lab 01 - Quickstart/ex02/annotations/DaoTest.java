package ex02.annotations;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoTest {
	public static void main(String[] args) {
		/*Department dept = new Department();
		dept.setDepartmentNumber(70);
		dept.setDepartmentName("QMS");
		dept.setDepartmentLocation("Powai");
		
		DepartmentDAO dao = new DepartmentDAOImpl ();
		dao.createDepartment(dept);
		*/
		
		/*DepartmentDAO dao = new DepartmentDAOImpl ();
		Department ref = dao.selectDepartment(60);
		System.out.println("ref "+ref);*/
		
		/*DepartmentDAO dao = new DepartmentDAOImpl ();
		dao.deleteDepartment(70);*/
		
		Department dept = new Department();
		dept.setDepartmentNumber(50);
		dept.setDepartmentName("QMS");
		dept.setDepartmentLocation("Powai");
		
		DepartmentDAO dao = new DepartmentDAOImpl ();
		dao.updateDepartment(dept);
	}
}
interface DepartmentDAO
{
	//CRUD
	void 				createDepartment(Department ref); //insert
	void 				updateDepartment(Department ref); //update
	void 				deleteDepartment(int deptno); //delete
	Department 			selectDepartment(int deptno); //select with PK
	List<Department>	selectDepartments(); // select all
//	List<Department>	selectDepartmentByLocation();
}

class DepartmentDAOImpl implements DepartmentDAO
{
	Connection conn ; 
	DepartmentDAOImpl() {
		//conn = MyConnection.createConnection();
		//session factory setting is here
	}
	@Override
	public void createDepartment(Department ref) {
		
//		tx.begin
	//	session.save(ref);
		//tx.commit
		
	}

	@Override
	public void updateDepartment(Department ref) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst = conn.prepareStatement("update dept set dname=?, loc=? where deptno=?");
			
			pst.setString(1, ref.getDepartmentName());
			pst.setString(2, ref.getDepartmentLocation());
			pst.setInt(3, ref.getDepartmentNumber());
			int row = pst.executeUpdate();
			System.out.println("updated...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteDepartment(int deptno) {
		// TODO Auto-generated method stub
		
		try {
			PreparedStatement pst = conn.prepareStatement("delete from dept where deptno=?");
			pst.setInt(1, deptno);
			int row = pst.executeUpdate();
			System.out.println("deleted...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public Department selectDepartment(int deptno) {
		// TODO Auto-generated method stub
		Department deptObj=null;
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from dept where deptno="+deptno);
			if(rs.next()) {
				deptObj = new Department(); //blank
				deptObj.setDepartmentNumber(rs.getInt(1));
				deptObj.setDepartmentName(rs.getString(2));
				deptObj.setDepartmentLocation(rs.getString(3));
			}
			System.out.println("selected single...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return deptObj;
	}

	@Override
	public List<Department> selectDepartments() {
		// TODO Auto-generated method stub
		List<Department> deptList = new ArrayList<Department>();
		Department deptObj=null;
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from dept ");
			while(rs.next()) {
				deptObj = new Department(); //blank
				deptObj.setDepartmentNumber(rs.getInt(1));
				deptObj.setDepartmentName(rs.getString(2));
				deptObj.setDepartmentLocation(rs.getString(3));
				
				//dont forget this line below
				deptList.add(deptObj);
			}
			System.out.println("selected All...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return deptList;
	}
	
}
//package / public  
class Department //mapped as per the DEPT table structure
{
	private int departmentNumber;
	private String departmentName;
	private String departmentLocation;
	
	public Department() {
		super();
		System.out.println("Department ctor...called...");
	}

	public int getDepartmentNumber() {
		return departmentNumber;
	}

	public void setDepartmentNumber(int departmentNumber) {
		this.departmentNumber = departmentNumber;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentLocation() {
		return departmentLocation;
	}

	public void setDepartmentLocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}

	@Override
	public String toString() {
		return "Department [departmentNumber=" + departmentNumber + ", departmentName=" + departmentName
				+ ", departmentLocation=" + departmentLocation + "]";
	}
	
	
	
}