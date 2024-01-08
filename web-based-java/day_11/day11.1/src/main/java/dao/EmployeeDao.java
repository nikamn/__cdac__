package dao;

import pojos.Employee;

public interface EmployeeDao {
	String saveEmpDetails(Employee transientEmp,Long deptId);
	
	String removeEmpFromDept(String deptName,String email);
}
