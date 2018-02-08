package com.eoy.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "employee")
public class Employee implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name ="empid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer empid;
	

	@Column(unique=true , name ="empno")
	private Integer empNo;
		
	@Column(name ="empname")
	private String empName;
	
	@JsonIgnore
	@Column(name ="password")
	private String password;
	
	@Column(name ="designation")
	private String designation;
	
	@Column(name ="serviceline")
	private String serviceLine;

	@Column(name ="role")
	private String role;

	public Integer getEmpid() {
		return empid;
	}

	/*public void setEmpid(Integer empid) {
		this.empid = empid;
	}*/

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getServiceLine() {
		return serviceLine;
	}

	public void setServiceLine(String serviceLine) {
		this.serviceLine = serviceLine;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
