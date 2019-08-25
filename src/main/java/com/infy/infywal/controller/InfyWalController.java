package com.infy.infywal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infy.infywal.service.EmployeeInfoService;

@RestController
@CrossOrigin
public class InfyWalController {
	@Autowired
	private EmployeeInfoService employeeInfoService;

	
	@RequestMapping(value="/",method= {RequestMethod.GET})
	public ResponseEntity<String> getInfy(){
		System.out.println("Idiottt");
		employeeInfoService.getEmpinfo();
		return new ResponseEntity<>("Fuck Youuuu", HttpStatus.OK);
	}
}
