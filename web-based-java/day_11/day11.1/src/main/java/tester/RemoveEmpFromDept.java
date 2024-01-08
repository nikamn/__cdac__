package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;

public class RemoveEmpFromDept {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			EmployeeDao empDao = new EmployeeDaoImpl();
			System.out.println(
					"Enter dept name and emp's emailto be removed");
				System.out.println(empDao.removeEmpFromDept(sc.next(),sc.next()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
