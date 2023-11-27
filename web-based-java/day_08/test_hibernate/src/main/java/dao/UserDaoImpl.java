package dao;

import pojos.User;
import org.hibernate.*;

import static utils.HibernateUtils.getSessionFactory;

public class UserDaoImpl implements UserDao {

	@Override
	public String registerUser(User user) {
		// 1. open session from SessionFactory
		Session session = getSessionFactory().openSession();

		// 2. begin a transaction
		Transaction tx = session.beginTransaction();

		try {
			session.save(user);
			// success : commit
			tx.commit();
		} catch (RuntimeException e) {
			// rollback tx and re throw the exception to the caller
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (session != null)
				session.close();
		}
		return "User registered with ID " + user.getUserId();
	}

}
