package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;

public class DeleteEmpDetailsById {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			EmployeeDao empDao = new EmployeeDaoImpl();
			System.out.println("Enter emp id to delete the details: ");
			System.out.println(empDao.deleteEmpDetails(sc.nextLong()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
