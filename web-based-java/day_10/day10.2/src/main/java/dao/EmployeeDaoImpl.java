package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Department;
import pojos.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String saveEmpDetails(Employee emp, Long deptId) {
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			Department dept = session.get(Department.class, deptId);
			if (dept != null) {
				dept.addEmployee(emp);
				session.persist(emp);
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return "Emp details added with ID: " + emp.getId();
	}

}
