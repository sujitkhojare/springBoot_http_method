package com.intutech.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intutech.dto.Employee;
import com.intutech.dto.Student;
import com.intutech.service.StudentService;

@RestController
public class StudentController { 
	
	@Autowired
	StudentService services ; 
	
	@PostMapping("/insertion")
	//    http://localhost:8080/insertion
	public String insertion(@RequestBody Student stud) { 
		boolean result = services.insertData(stud);
		if(result) { 
			return  "Student information Added Sucuessfully" ;
		}
		else 
			return "Student info is not able to added ";
	}
	//http://localhost:8080/retrive
	@GetMapping("/retrive")
	public ArrayList<Student>retrive(){ 	
		return services.getData();
	}
	
	
	@DeleteMapping("/deleteStudById")
    public String deleteStudById(@RequestParam("sid") int sid) { 
        boolean result = services.deleteStud(sid);
		
        if (result) { 
            return "Student deleted successfully"; 
        } else { 
            return "Unable to delete Student details";
        }
    }
	
     //http://localhost:8080/getEmpById/13
	@GetMapping("/getStudById/{id}")
	public Student getStudById(@PathVariable(value = "id") int id) {
		return services.getStudById(id);
	}
}


