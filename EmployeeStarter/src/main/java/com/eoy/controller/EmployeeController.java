package com.eoy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eoy.pojo.Employee;
import com.eoy.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/getAllEmployee",method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> empList = (List<Employee>) employeeService.getAllEmployeeDetails();
		return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/checkDuplicateEmpNo", method = RequestMethod.POST)
	public ResponseEntity<Boolean> checkDuplicateEmpNo(@RequestParam(value = "empNo") Integer empNo) {
		return new ResponseEntity<>(employeeService.checkDuplicateEmpNo(empNo), HttpStatus.OK);
	}
	
	
}
