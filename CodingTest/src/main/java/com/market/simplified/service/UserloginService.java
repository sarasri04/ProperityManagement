package com.market.simplified.service;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.market.simplified.entity.EmployeeEntity;
import com.market.simplified.entity.UserloginEntity;
import com.market.simplified.entity.model.EmployeeReqest;
import com.market.simplified.entity.model.UserloginReqest;
import com.market.simplified.repositoryImpl.EmployeeRepos;
import com.market.simplified.repositoryImpl.UserloginRepo;

@Service
public class UserloginService {

	
	@Autowired
	UserloginRepo userloginRepo;
	@Autowired
	EmployeeRepos employeeRepos;

	public String getUserDetails(String userName,String password) {
		String response;
		String reslt=userloginRepo.getUser(userName,password);
		System.out.println(reslt);
		// null, record
		if(reslt == null) { // null == null ---- sara == null
			response = "user not avalible"; //
		}else {
			response = "user avalible";
		}
		return response;
		
	}
	
	
	public String addRegister(UserloginReqest userloginReqest) {
		UserloginEntity temp = new UserloginEntity();
		temp.setUserName(userloginReqest.getUserName());
		temp.setPassWord(userloginReqest.getPassword());
		temp.setMobileNumber(userloginReqest.getMobileNumber());
		temp.setRole(userloginReqest.getRole());
		temp.setEmailId(userloginReqest.getEmailId());
		userloginRepo.save(temp);
		return "success";
	}
	
	public String addDetaile(EmployeeReqest employeeReqest) {
	
		EmployeeEntity num = new EmployeeEntity();
		String dob = employeeReqest.getDob();
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
		Date date = null;
		try {
			//date = sdf.parse(sdf.format(dob));
		   date = inputFormat.parse(dob);
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
		//LocalDate date = LocalDate.parse(dob, formatter);
		System.out.println(date); // 2010-01-02
		
		num.setEmpId(employeeReqest.getEmpId());
		num.setEmpName(employeeReqest.getEmpName());
		num.setDob(date);
		num.setEmpemailid(employeeReqest.getEmpemailid());
		num.setEmpAddress(employeeReqest.getEmpAddress());
		employeeRepos.save(num);
	    return "success";
	}

	 



	
}
