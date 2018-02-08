package com.eoy.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eoy.pojo.Employee;
import com.eoy.service.LoginService;

/**
 * 
 * @author kritikjain
 *
 */
@RestController
@RequestMapping("/register")
public class LoginController {

	@Autowired
	private LoginService loginService;

	/**
	 * 
	 * @param employee
	 * @return
	 */
	@RequestMapping(value = "/signUp", consumes = { "application/json" }, method = RequestMethod.POST)
	public ResponseEntity<Map<String, String>> signUp(@RequestBody Employee employee) {
		return new ResponseEntity<>(loginService.signUp(employee), HttpStatus.OK);
	}

	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	public ResponseEntity<Map<String, String>> signIn(@RequestParam(value = "empNo") Integer empNo,
			@RequestParam(value = "password") String password) {
		return new ResponseEntity<>(loginService.signIn(empNo, password), HttpStatus.OK);
	}

	
	
	
}
