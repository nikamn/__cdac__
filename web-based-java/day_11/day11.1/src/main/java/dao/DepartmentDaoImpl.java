package dao;

import pojos.Department;
import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

public class DepartmentDaoImpl implements DepartmentDao {

	@Override
	public String addNewDepartment(Department dept) {
		String mesg = "Adding new dept failed!!!!!";

		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			session.persist(dept);
			tx.commit();
			mesg = "Added new dept with ID: " + dept.getId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public Department getDepartmentDetails(String deptName) {
		Department dept = null;
		String jpql = "select d from Department d where d.name=:name";

		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			dept = session.createQuery(jpql, Department.class).setParameter("name", deptName).getSingleResult();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return dept;
	}

	@Override
	public Department getDepartmentAndEmpDetails(String deptName) {
		Department dept = null;
		String jpql = "select d from Department d where d.name=:name";

		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			dept = session.createQuery(jpql, Department.class).setParameter("name", deptName).getSingleResult();
			dept.getEmployees().size();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return dept;
	}

	@Override
	public Department getDepartmentAndEmpDetailsJoinFetch(String deptName) {
		Department dept = null;
		String jpql = "select d from Department d left join fetch d.employees where d.name=:name";

		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			dept = session.createQuery(jpql, Department.class).setParameter("name", deptName).getSingleResult();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return dept;
	}
}
