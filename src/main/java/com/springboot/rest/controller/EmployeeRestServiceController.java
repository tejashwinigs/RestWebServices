package com.springboot.rest.controller;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.model.Emplo;

@RestController
@RequestMapping("/rest/employee")
public class EmployeeRestServiceController {

	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(){
		System.out.println("Rst application");
		return new ResponseEntity<String>("saved",HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<String> getAllEmployees(){
		return new ResponseEntity<String>("Employee data",HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(){
		return new ResponseEntity<String>("Updated",HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteEmployee(){
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
	
	@GetMapping("/save/emp")
	public Emplo saveEmp() {
		Emplo e= new Emplo();
		e.setId(1);
		e.setName("aaa");
		return e;
	}
	
	@GetMapping("/save/emps")
	public ResponseEntity<Emplo> saveEmps(){
		return new ResponseEntity<Emplo>(new Emplo(1,"www"),HttpStatus.CREATED);
	}
	
	@PostMapping("/saveEmp")
	public String saveDAta(@RequestBody Emplo emp) {
		return "Data is "+emp.toString();
	}
	
	@GetMapping("/show")
	public ResponseEntity<String> show(){
		
		int id= new Random().nextInt(100);
		ResponseEntity<String> rs=null;
		System.out.println(id);
		try {
		if(id>=0) {
			
			return new ResponseEntity<String>("New Emp created",HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>("Invalid",HttpStatus.BAD_REQUEST);
		}
		}catch(Exception e) {
			e.printStackTrace();
			rs=new ResponseEntity<String>("Problem found"+ e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return rs;
	}
	
	@GetMapping("/find/{id}")
	public String get(@PathVariable Integer id){
		return "id is "+id;
	}
	
	////////////////////////////////Interview question////////////////
	//here both url are same but when we hit url from client then always it will hit static one
//	@GetMapping("/find/{id}")
//	public String getA(@PathVariable String id){
//		return "id is "+id;
//	}
//	
//	
//	@GetMapping("/find/id")
//	public String getB(){
//		return "Data is none";
//	}
	/////////////////////////////////////////////////////////////////////////
}
