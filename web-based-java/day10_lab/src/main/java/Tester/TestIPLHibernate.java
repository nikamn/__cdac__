package Tester;

import static utils.HibernateUtils.*;

import org.hibernate.SessionFactory;

public class TestIPLHibernate {

	public static void main(String[] args) {
		try (SessionFactory sessionFactory = getFactory()) {
			System.out.println("Hibernate booted successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
