package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;

public class GetAllEmps {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			EmployeeDao empDao = new EmployeeDaoImpl();
			System.out.println("All emps : ");
			empDao.getAllEmps().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
