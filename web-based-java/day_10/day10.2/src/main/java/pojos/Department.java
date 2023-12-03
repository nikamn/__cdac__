package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "depts")
public class Department extends BaseEntity {
	@Column(length = 30, unique = true)
	private String name;

	@Column(length = 60)
	private String location;

	@OneToMany(mappedBy = "myDept")
	private List<Employee> employees = new ArrayList<>();

	public Department() {
	}

	public Department(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", location=" + location + "]";
	}

	public void addEmployee(Employee e) {
		employees.add(e);
		e.setMyDept(this);
	}

	public void removeEmployee(Employee e) {
		employees.remove(e);
		e.setMyDept(null);
	}

}
