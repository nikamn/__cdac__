package dao;

import pojos.Employee;
import pojos.EmploymentType;

import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String saveEmpDetails(Employee emp) {
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		System.out.println("session open " + session.isOpen() + " is connected " + session.isConnected());// t t
		// L1 cache is created.

		try {
			Serializable id = session.save(emp);// emp : PERSISTENT (exists in L1 cache) BUT not yet part of DB
			System.out.println("generated id " + id);
			tx.commit(); // session is auto closed =>
			// 1. session.flush() --> 2. hib performs auto dirty checking
			// compares L1 cache with DB state : hib fires insert query
			// to sync up state of DB with L1 cache
			// 3. L1 cache is destroyed n pooled out db cn rets to
			// the pool n then session is closed.
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// no auto dirty checking --- session is auto closed =>
			// L1 cache is destroyed n pooled out db cn rets to the pool
			// re throw the exc to the caller
			throw e;
		}
		System.out.println("session open " + session.isOpen() + " is connected " + session.isConnected());// f f
		// emp : DETACHED (from L1 cache)
		return "Emp details added , with ID " + emp.getEmpId();
	}

	@Override
	public Employee getEmpDetailsById(long empId) {
		Employee emp = null;// state : DOES NOT exist
		// 1. Get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a tx
		Transaction tx = session.beginTransaction();
		try {
			// get emp details
			emp = session.get(Employee.class, empId);// select
			emp = session.get(Employee.class, empId);// rets from cache
			emp = session.get(Employee.class, empId);// rets from cache
			// in case of valid id , emp : PERSISTENT(part of L1 cache , part of DB)
			// invalid id : emp : null
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return emp;// emp : DETACHED
	}

	@Override
	public List<Employee> getAllEmps() {
		List<Employee> emps = null;
		String jpql = "select e from Employee e";

		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			emps = session.createQuery(jpql, Employee.class) // Query<Employee>
					.getResultList();
			// emps : list of PERSISTENT entities.

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return emps;
	}

	@Override
	public List<Employee> getSelectedEmps(LocalDate begin, LocalDate end, double minSal) {
		List<Employee> emps = null;
		String jpql = "select e from Employee e where e.joinDate between :begin_dt and :end_dt and e.salary > :min";

		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			emps = session.createQuery(jpql, Employee.class).setParameter("begin_dt", begin).setParameter("end_dt", end)
					.setParameter("min", minSal).getResultList();

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return emps;

	}

	@Override
	public List<String> getLastNamesByEmpType(EmploymentType type) {
		List<String> lastNames = null;
		String jpql = "select e.lastName from Employee e where e.empType=:ty";

		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			lastNames = session.createQuery(jpql, String.class).setParameter("ty", type).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return lastNames;
	}

	@Override
	public List<Employee> getSelectedEmpsByCtorExpression(EmploymentType type1) {
		List<Employee> emps = null;
		String jpql = "select new pojos.Employee(firstName,lastName,salary) from Employee e where e.empType=:type";

		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			emps = session.createQuery(jpql, Employee.class).setParameter("type", type1).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return emps;
	}

	@Override
	public String updateEmpSal(String email, String pwd, double increment) {
		String mesg = "Salary updating failed ...!";
		String jpql = "select e from Employee e where e.email=:em and e.password=:pass";
		Employee emp = null;

		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			emp = session.createQuery(jpql, Employee.class).setParameter("em", email).setParameter("pass", pwd)
					.getSingleResult();
			emp.setSalary(emp.getSalary() + increment);
			tx.commit();
			mesg = "emp's salary updated ...!";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		emp.setSalary(emp.getSalary() + increment);
		return mesg;
	}

}
