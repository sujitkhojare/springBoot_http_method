package com.intutech.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.intutech.dto.Employee;

@Service
public class EmployeeService { 
	
	private ArrayList<Employee> emplist = new ArrayList<Employee>();
	
	// insert operation 
	
	public boolean addEmployee(Employee emp) { 
		return emplist.add(emp);
	}
	
	// get emp or retrive 
	
	public ArrayList<Employee>getAllEmp(){ 
		return emplist ;
	}
	
	// delete emp using id 
	
	public boolean deleteEmployeeById(int eid) { 
		Employee employee = getEmpById(eid);
		return emplist.remove(employee);
	}
	
	// for seraching emp based  on id 
	
	public Employee getEmpById(int id) {
		Employee employee = null;
		for(Employee e : emplist) {
			if(e.getEid() == id) {
				employee = e;
				break;
			}
		}
		return employee;
	}
	
	public boolean  updateEmp(int id , String email) { 
		Employee emp =  getEmpById(id);
		emp.setEmail(email);
		return true ;
	}
}
