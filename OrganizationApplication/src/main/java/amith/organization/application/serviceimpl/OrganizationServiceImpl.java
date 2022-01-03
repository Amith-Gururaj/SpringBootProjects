package amith.organization.application.serviceimpl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amith.organization.application.entity.Department;
import amith.organization.application.entity.Employee;
import amith.organization.application.exception.UserDefException;
import amith.organization.application.repository.DepartmentRepository;
import amith.organization.application.repository.EmployeeRepository;
import amith.organization.application.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService
{
	@Autowired
	private EmployeeRepository emprepo;
	
	@Autowired
	private DepartmentRepository deptrepo;

	public OrganizationServiceImpl(EmployeeRepository emprepo, DepartmentRepository deptrepo) {
		super();
		this.emprepo = emprepo;
		this.deptrepo = deptrepo;
	}
		
	@Override
	public String saveEmployee(Employee e) throws UserDefException 
	{
		Department dept = e.getDepartment();
		List<Employee> emp = emprepo.findByDepartment(dept.getDeptid());
		if(emp.size()>=dept.getMaxemp())
			throw new UserDefException("For this department exceeds the limit of number of employees");
		else
		{
			emprepo.save(e);
			return "Employee Added Successfully";
		}
	}

	@Override
	public String saveDepartment(Department d) {
		deptrepo.save(d);
		return "Department Added Successfully";
	}

	@Override
	public Iterable<Employee> getAllEmployees() {
		return emprepo.findAll();
	}

	@Override
	public Iterable<Department> getAllDepartments() {
		List<Department> dept = deptrepo.findAll();
		Collections.sort(dept);
		return dept;
	}

	@Override
	public Department updateParticularDepartment(Long deptid, int newmaxemp) throws UserDefException {
		Department dept = deptrepo.findByDeptid(deptid);
		if(dept==null)
			throw new UserDefException("No such department there in database");
		else
		{
			deptrepo.updateDept(deptid,newmaxemp);
			Department res = deptrepo.findById(deptid).get();
			return res;
		}	
	}
}
