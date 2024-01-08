package dao;

import pojos.Department;

public interface DepartmentDao {
	String addNewDepartment(Department dept);

	Department getDepartmentDetails(String deptName);

	Department getDepartmentAndEmpDetails(String deptName);

	Department getDepartmentAndEmpDetailsJoinFetch(String deptName);
}
