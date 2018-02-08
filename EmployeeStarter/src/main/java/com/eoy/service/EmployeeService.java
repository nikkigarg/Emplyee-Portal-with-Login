package com.eoy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eoy.pojo.Employee;
import com.eoy.repo.EmployeeRepository;

@Service
public class EmployeeService  {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Boolean checkDuplicateEmpNo(Integer empNo) {
		return employeeRepository.checkDuplicateEmpNo(empNo);
	}
	
	
    public List<Employee> getAllEmployeeDetails(){
    	List<Employee> empDetails = (List<Employee>) employeeRepository.findAll();
    	return empDetails;
    }
    
    
    

}
