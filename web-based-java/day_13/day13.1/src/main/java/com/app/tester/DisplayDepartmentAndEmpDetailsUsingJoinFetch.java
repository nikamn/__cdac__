package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.DepartmentDao;
import com.app.dao.DepartmentDaoImpl;
import com.app.dao.EmployeeDao;
import com.app.dao.EmployeeDaoImpl;
import com.app.pojos.Department;
import com.app.pojos.Employee;
import com.app.pojos.EmploymentType;

public class DisplayDepartmentAndEmpDetailsUsingJoinFetch {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			DepartmentDao dao = new DepartmentDaoImpl();
			System.out.println("Enter dept name");
			Department department = dao.getDepartmentAndEmpDetailsJoinFetch(sc.next());
			System.out.println("Dept details ");
			System.out.println(department);
			System.out.println("Emp details ");
			department.getEmployees().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
