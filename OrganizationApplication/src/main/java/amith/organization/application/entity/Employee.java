package amith.organization.application.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Employee 
{
	@Id
	private Long id;
	private String name;
	private int salary;
	private String gender;
	private int age;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="deptid", referencedColumnName="deptid")
	@JsonBackReference
	private Department department;

	public Employee() {
		super();
	}

	public Employee(Long id, String name, int salary, String gender, int age, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.gender = gender;
		this.age = age;
		this.department = department;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", gender=" + gender + ", age=" + age
				+ ", department=" + department + "]";
	}
}
