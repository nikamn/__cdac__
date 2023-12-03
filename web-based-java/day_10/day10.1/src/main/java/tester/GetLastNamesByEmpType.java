package tester;

import static utils.HibernateUtils.getFactory;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import pojos.EmploymentType;

public class GetLastNamesByEmpType {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			EmployeeDao empDao = new EmployeeDaoImpl();
			System.out.println("Enter employment type: ");
			List<String> list = empDao.getLastNamesByEmpType(EmploymentType.valueOf(sc.next().toUpperCase()));
			System.out.println("Last Names: ");
			list.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
