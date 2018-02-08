package com.eoy.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eoy.pojo.Employee;
import com.eoy.repo.EmployeeRepository;
import com.eoy.util.ServiceConstants;

/**
 * 
 * @author kritikjain
 *
 */
@Service
public class LoginService {

	@Autowired
	private EmployeeRepository employeeRepository;


	/**
	 * 
	 * @param employee
	 * @return
	 */
	public Map<String,String> signUp(Employee employee) {

		Map<String,String> statusMap = new HashMap<String,String>();
		Employee emp = employeeRepository.save(employee);

		if(emp!=null) {
			statusMap.put(ServiceConstants.SUCCESS, ServiceConstants.EMP_SAVE_SUCCESS);
		}else {
			statusMap.put(ServiceConstants.ERROR, ServiceConstants.EMP_SAVE_ERROR);
		}
		return statusMap;
	}


	public Map<String, String> signIn(Integer empNo, String password) {
		Map<String,String> statusMap = new HashMap<String,String>();
		
		//fetch user by emp no. Check username and password. Send emp object on success
		Employee emp  = employeeRepository.getEmployeeByNumber(empNo);
		if(emp == null) {
			statusMap.put(ServiceConstants.ERROR, ServiceConstants.INVALID_USRENAME);
		}else if(!emp.getPassword().equals(password)) {
			statusMap.put(ServiceConstants.ERROR, ServiceConstants.INVALID_PASSWORD);
		}else {
			statusMap.put(ServiceConstants.SUCCESS, ServiceConstants.EMP_LOGIN_SUCCESS);
		}
		return statusMap;
	}



}
