package com.example.project3_test.controller.Dashboard_Controller.Admin_Dashboard.assign_Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.project3_test.DAO_Repository.DAOInterface2;
import com.example.project3_test.Service.emailSender.emailSender;
import com.example.project3_test.model.Client;
import com.example.project3_test.model.ContactPerson;
 
@Controller

@RequestMapping(path="/contactperson" )
public class addContactPersonToClient_Controller {
	@Autowired
	DAOInterface2 DAOImpl;
	 
	
	
	@ResponseBody
	@RequestMapping(path="/{clientId}", method=RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Object addContactPersonToClient (@PathVariable(name="clientId") String clientId,@RequestBody ContactPerson ContactPerson) {
		System.out.println("addContactPersonToClient handler method in addContactPersonToClient_Controller.java");
		 
		
		 // adding incoming contactperson for client id in contact person DB
			Client Client=DAOImpl.InsertContactPersonInClient(clientId,ContactPerson);
			 
			
			return Client;
			
			
		
	}
}
