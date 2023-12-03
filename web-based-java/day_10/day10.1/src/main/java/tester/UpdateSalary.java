package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;

public class UpdateSalary {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			EmployeeDao empDao = new EmployeeDaoImpl();
			System.out.println("Enter emp email, password and salary increment(double)");
			System.out.println(empDao.updateEmpSal(sc.next(), sc.next(), sc.nextDouble()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
