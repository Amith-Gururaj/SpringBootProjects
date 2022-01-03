package amith.organization.application.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Department implements Comparable<Department>
{
	@Id
	private Long deptid;
	private String deptname;
	private int maxemp;
	
	@OneToMany(mappedBy="department")
	@JsonManagedReference
	private List<Employee> employees;

	public Department() {
		super();
	}

	public Department(Long deptid, String deptname, int maxemp, List<Employee> employees) {
		super();
		this.deptid = deptid;
		this.deptname = deptname;
		this.maxemp = maxemp;
		this.employees = employees;
	}

	public Long getDeptid() {
		return deptid;
	}

	public void setDeptid(Long deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public int getMaxemp() {
		return maxemp;
	}

	public void setMaxemp(int maxemp) {
		this.maxemp = maxemp;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [deptid=" + deptid + ", deptname=" + deptname + ", maxemp="
				+ maxemp + ", employees=" + employees + "]";
	}

	@Override
	public int compareTo(Department o) {
		return this.deptname.compareTo(o.deptname);
	}
	
}
