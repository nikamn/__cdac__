package tester;

import static utils.HibernateUtils.getFactory;

import org.hibernate.SessionFactory;

public class TestHibernate {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory()) {
			System.out.println("hibernate up and running ...!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
