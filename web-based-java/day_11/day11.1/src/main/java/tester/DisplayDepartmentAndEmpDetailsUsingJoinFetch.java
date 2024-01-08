package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.DepartmentDao;
import dao.DepartmentDaoImpl;
import pojos.Department;

public class DisplayDepartmentAndEmpDetailsUsingJoinFetch {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			DepartmentDao dao = new DepartmentDaoImpl();
			System.out.println("Enter dept name :");
			Department department = dao.getDepartmentAndEmpDetailsJoinFetch(sc.next());
			System.out.println("Dept details :");
			System.out.println(department);
			System.out.println("Emp details :");
			department.getEmployees().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
