package amith.organization.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import amith.organization.application.entity.Department;
import amith.organization.application.entity.Employee;
import amith.organization.application.exception.UserDefException;
import amith.organization.application.service.OrganizationService;

@RestController
@RequestMapping(path="/organization")
public class OrganizationController 
{
	@Autowired
	private OrganizationService orgservice;

	public OrganizationController(OrganizationService orgservice) {
		super();
		this.orgservice = orgservice;
	}
	
	@PostMapping(path="/employee/add")
	public String addEmployee(@RequestBody Employee e) throws UserDefException
	{
		return orgservice.saveEmployee(e);
	}
	
	@PostMapping(path="/department/add")
	public String addDepartment(@RequestBody Department d)
	{
		return orgservice.saveDepartment(d);
	}
	
	@GetMapping(path="/employee/getall")
	public Iterable<Employee> getEmployees()
	{
		return orgservice.getAllEmployees();
	}
	
	@GetMapping(path="/department/getall")
	public Iterable<Department> getDepartments()
	{
		return orgservice.getAllDepartments();
	}
	
	@PutMapping(path="/department/updatemaxempl/{deptid}/{maxemp}")
	public Department getParticularDepartment(@PathVariable("deptid") Long deptid,@PathVariable("maxemp") int newmaxemp) throws UserDefException
	{
		
			return orgservice.updateParticularDepartment(deptid,newmaxemp);	
	}
}
