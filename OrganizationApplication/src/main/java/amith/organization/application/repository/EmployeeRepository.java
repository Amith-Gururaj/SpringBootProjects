package amith.organization.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import amith.organization.application.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>
{
	@Query("FROM Employee e JOIN e.department d where d.deptid=?1")
	List<Employee> findByDepartment(Long deptid);
}
