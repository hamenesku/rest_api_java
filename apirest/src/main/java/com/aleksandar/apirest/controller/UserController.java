package com.aleksandar.apirest.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aleksandar.apirest.models.Example;

@RestController
public class UserController {
	
	@Autowired
	Example exa;
	
//	@RequestMapping(value="/addUser",method=RequestMethod.GET)
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String something() {
		
		exa.getTest();
		
		return "hello";
	}

}
