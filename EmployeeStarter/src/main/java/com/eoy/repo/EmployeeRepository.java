package com.eoy.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eoy.pojo.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer>{

	@Query("select e from Employee e where e.empNo = ?")
	Employee getEmployeeByNumber(Integer empNo);
	
	@Query(" SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END " + 
			"FROM Employee e WHERE e.empNo = ? ")
	Boolean checkDuplicateEmpNo(Integer empNo);

	

}
