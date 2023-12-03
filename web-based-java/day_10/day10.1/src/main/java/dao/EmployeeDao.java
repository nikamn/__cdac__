package dao;

import java.time.LocalDate;
import java.util.List;

import pojos.Employee;
import pojos.EmploymentType;

public interface EmployeeDao {
	String saveEmpDetails(Employee transientEmp);

	Employee getEmpDetailsById(long empId);

	List<Employee> getAllEmps();

	List<Employee> getSelectedEmps(LocalDate begin, LocalDate end, double minSal);

	List<String> getLastNamesByEmpType(EmploymentType type);

	List<Employee> getSelectedEmpsByCtorExpression(EmploymentType type);

	String updateEmpSal(String email, String pwd, double increment);

	String bulkUpdateEmpSalaryByDate(double increment, LocalDate date);

	String deleteEmpDetails(Long empId);
}
