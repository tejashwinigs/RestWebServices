package com.springboot.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//@Controller + @ResponseBody
public class MessageRestController {

	//Method return type = RESPONSENTITY<T>,String,T,Collection...etc
	//Path(URL) + HTTP Method(POST,PUT,DELETE,GET,PATCH)
	@GetMapping("/show")
	public ResponseEntity<String> showMsg(){
		String body ="WELCOME TO FIRST APP";
		ResponseEntity<String> re = new ResponseEntity<String>(body,HttpStatus.OK);
		
		return re;
	}
}
