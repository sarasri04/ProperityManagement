package com.market.simplified.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.market.simplified.entity.model.EmployeeReqest;
import com.market.simplified.entity.model.UserloginReqest;
import com.market.simplified.service.UserloginService;


@RestController

public class UserLoginController {
	
	@Autowired
	UserloginService userloginService;

	@GetMapping(value = "/userLogin")
	public String addUserlogin(@RequestParam String userName,@RequestParam String password) {
		String result=userloginService.getUserDetails(userName,password);
		return result;
	}
	
	@PostMapping(value="/userRegister")
	public String addRegister(@RequestBody UserloginReqest userloginReqest) {
		return userloginService.addRegister(userloginReqest);
	}
	
	
	@PostMapping(value="/employeeDetaile")
	public String addDetaile(@RequestBody EmployeeReqest employeeReqest) {
		return userloginService.addDetaile(employeeReqest); 
	}

	 

}
