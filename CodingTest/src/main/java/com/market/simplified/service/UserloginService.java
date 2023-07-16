package com.market.simplified.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.market.simplified.entity.model.UserloginReqest;
import com.market.simplified.repositoryImpl.UserloginRepo;

@Service
public class UserloginService {

	@Autowired
	UserloginRepo userloginRepo;

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
		userloginRepo.save(userloginReqest);
		return "success";
	}



	
}
