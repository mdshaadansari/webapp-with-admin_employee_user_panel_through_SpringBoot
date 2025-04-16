package com.example.project3_test.controller.Dashboard_Controller.Admin_Dashboard.addMemebers_Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.project3_test.DAO_Repository.DAOInterface2;
import com.example.project3_test.Service.Admin_Dashboard.addMemebers_Service.createEmployee_Service;
import com.example.project3_test.Service.emailSender.emailSender;
import com.example.project3_test.model.Employee;

@Controller
@RequestMapping(path = "/employee")
public class createEmployee_Controller {

	@Autowired
	DAOInterface2 DAOImpl;

	@Autowired
	emailSender emailSender;

	@Autowired
	createEmployee_Service createEmployee_Service;
 
@ResponseBody
	@RequestMapping (method= RequestMethod.POST)
	Object addEmployeeInDB ( @RequestBody Employee employee){
		

		System.out.println("addEmployeeInDB handler method in createEmployee_Controller.java"); 
 

		Employee result=createEmployee_Service.addEmployeeInDB_Service(employee);

if(result==null ){ 
				 return Map.of("message","employee not inserted in DB"); 
	}
	return result;
	}
 
	
}