package com.infy.infywal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class InfyWalController {

	
	@RequestMapping(value="/",method= {RequestMethod.GET})
	public ResponseEntity<String> getInfy(){
		System.out.println("Idiottt");
		return new ResponseEntity<>("Fuck Youuuu", HttpStatus.OK);
	}
}
