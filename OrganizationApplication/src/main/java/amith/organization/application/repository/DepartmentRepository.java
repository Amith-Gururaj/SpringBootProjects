package amith.organization.application.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import amith.organization.application.entity.Department;

@Repository
@Transactional
public interface DepartmentRepository extends JpaRepository<Department,Long>
{
	@Modifying
	@Query("update Department d set d.maxemp=?2 where d.deptid=?1")
	void updateDept(Long deptid, int newmaxemp);

	@Query("from Department d where d.deptid=?1")
	Department findByDeptid(Long deptid);
}
