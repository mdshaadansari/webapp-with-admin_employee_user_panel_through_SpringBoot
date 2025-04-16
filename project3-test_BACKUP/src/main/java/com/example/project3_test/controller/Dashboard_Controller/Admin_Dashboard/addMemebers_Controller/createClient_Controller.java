package com.example.project3_test.controller.Dashboard_Controller.Admin_Dashboard.addMemebers_Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.project3_test.Service.Admin_Dashboard.addMemebers_Service.createClient_Service;
import com.example.project3_test.model.Client; 
@Controller

@RequestMapping(path="/client") 
public class createClient_Controller {

	@Autowired
	createClient_Service createClient_Service;
	  
	
	@ResponseBody
	@RequestMapping(method= RequestMethod.POST) 
	ResponseEntity<Object> addClientInDB (@RequestBody Client client) { 
		System.out.println("addClientInDB handler method in createClient_Controller.java");
		
		
		
		Client result=createClient_Service.addClientInDB_Service(client);
		
		
		
		if(result!=null){
			return ResponseEntity .status(HttpStatus.CREATED).body( result);
	 
		
		}else {
			Map<String,String> map=new HashMap<>();
			map.put("message", "client and, contactperson not added"); 
			return ResponseEntity .status(HttpStatus.BAD_REQUEST).body( map);
		}
 
	}
				 
					 
			 
		// =========================================================

		 
		/*
	@ExceptionHandler(Exception.class)
	public String excep(HttpSession session,Model model,Exception e) {
		//if using model.addAttribute(@SessionAttribute to update or put  newly anything in session,in @ExceptionHandler method it will not work,
		//(if after doing model.addAttribute we use model.getAttribute then it will show but actually it will not get set in session scope),
		//use HttpSession object instead
		
		//in exception handeler method if we try to update that is set in session by model.addAttribute, by doing model.addAttribute, it will not update
		//use HttpSession object instead
		
		System.out.println("exception in createClient_Controller.java, sending back to admin dashboard");
		System.out.println(e.getMessage());
		 e.printStackTrace();
		 
		 
		 //not doing proper here, its kust testing, do validation first of data coming, then if validation fails then return to frontend with some message or,
		 //throw exception catch here and decide what mesage to give in frontend,
		 //else if validation is right the put data in DB
		System.out.println(session.getAttribute("clientId"));
		 session.setAttribute("comingFromaddClientButtonClick","comingFromaddClientButtonClick");
		// session.setAttribute("clientId","new client ID");
		System.out.println(session.getAttribute("clientId"));
		  return "adminDashboard";
		
	} */
}