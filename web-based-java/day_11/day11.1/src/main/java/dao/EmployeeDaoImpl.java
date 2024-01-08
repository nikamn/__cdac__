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
				// session.persist(emp); not required in case of cascading !
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return "Emp details added , with ID: " + emp.getId();
	}

	@Override
	public String removeEmpFromDept(String deptName, String email1) {
		String mesg = "Removing emp failed ...!";
		String deptJpql = "select d from Department d where d.name=:nm";
		String empJpql = "select e from Employee e where e.email=:em";

		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			Department dept = session.createQuery(deptJpql, Department.class).setParameter("nm", deptName)
					.getSingleResult();
			Employee emp = session.createQuery(empJpql, Employee.class).setParameter("em", email1).getSingleResult();
			dept.removeEmployee(emp);
			tx.commit();
			mesg = "Deleted emp details from dept " + deptName;
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
