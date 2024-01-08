package Tester;

import static utils.HibernateUtils.getFactory;

import org.hibernate.SessionFactory;

import dao.TeamDao;
import impl.TeamDaoImpl;

public class TestGetAllTeams {

	public static void main(String[] args) {
		try (SessionFactory sessionFactory = getFactory()) {
			TeamDao tDao = new TeamDaoImpl();

			System.out.println(tDao.getAllTeams());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
