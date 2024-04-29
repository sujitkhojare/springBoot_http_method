package com.intutech.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intutech.dto.Employee;
import com.intutech.service.EmployeeService;
//http://localhost:8080/swagger-ui/index.html
@CrossOrigin(value="*")// or provide server number 
@RestController
public class EmployeeController {
 
	@Autowired
	EmployeeService service ;   // obj of service classs
	
	//http://localhost:8080/saveemployee  (for insertion ) 
	@PostMapping("/saveemployee")
	public String saveemployee(@RequestBody Employee emp) { 
		boolean result = service.addEmployee(emp);
		
		if(result) { 
			return "employye save sucessfully"; 
			
		} 
		else { 
			return "unable save employee details";
		}
	}
	
	//http://localhost:8080/getEmployee(for retrive data ) 
	@GetMapping("/getEmployee")
	public ArrayList<Employee> getEmployee (){ 
		return service.getAllEmp();
	}
	
	//http://localhost:8080/deleteEmployee?eid=13 ( delete data ) 
		@DeleteMapping("/deleteEmployee")
	    public String deleteEmployeeById(@RequestParam("eid") int eid) { 
	        boolean result = service.deleteEmployeeById(eid);
			
	        if (result) { 
	            return "Employee deleted successfully"; 
	        } else { 
	            return "Unable to delete employee details";
	        }
	    }
		
	//http://localhost:8080/getEmpById/13
		@GetMapping("/getEmpById/{id}")
		public Employee getEmpById(@PathVariable(value = "id") int eid) {
			return service.getEmpById(eid);
		}
		
		@PutMapping("/updateEmp")
			public String updateEmployeeDetails(@RequestParam("eid") int eid,
			@RequestParam("email") String email) {
		service.updateEmp(eid, email);
		return "Employee Updated Successfully..";

	  }		
 }
