package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.DepartmentDao;
import dao.DepartmentDaoImpl;
import pojos.Department;

public class AddNewDept {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			DepartmentDao dao = new DepartmentDaoImpl();
			System.out.println("Enter new dept details : name n location");
			System.out.println(dao.addNewDepartment(new Department(sc.next(), sc.next())));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
