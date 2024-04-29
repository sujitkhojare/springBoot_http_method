package com.intutech.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.intutech.dto.Student;

@Service
public class StudentService {
 
	private  ArrayList<Student> studlist = new ArrayList<Student>();
	
	// insertion daat 
	public boolean insertData(Student stud) { 
		return studlist.add(stud);
	}
	// get data 
	public ArrayList<Student>getData(){ 
		return studlist ;
	} 
	
	 public boolean deleteStud(int sId) {
	        Student student = getStudById(sId);
	        return studlist.remove(student);
	    }

	    public Student getStudById(int id) {
	        Student student = null;
	        for (Student s : studlist) {
	            if (s.getsId() == id) {
	                student = s;
	                break;
	            }
	        }
	        return student;
	    }
}