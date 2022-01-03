package amith.organization.application.service;

import amith.organization.application.entity.Department;
import amith.organization.application.entity.Employee;
import amith.organization.application.exception.UserDefException;

public interface OrganizationService {

	public String saveEmployee(Employee e) throws UserDefException;

	public String saveDepartment(Department d);

	public Iterable<Employee> getAllEmployees();

	public Iterable<Department> getAllDepartments();

	public Department updateParticularDepartment(Long deptid, int newmaxemp) throws UserDefException;

}
