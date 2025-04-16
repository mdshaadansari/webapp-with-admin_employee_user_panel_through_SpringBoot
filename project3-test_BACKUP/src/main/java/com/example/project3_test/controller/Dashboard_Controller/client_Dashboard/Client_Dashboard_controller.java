package com.example.project3_test.controller.Dashboard_Controller.client_Dashboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.project3_test.DAO_Repository.DAOInterface2;
import com.example.project3_test.model.Client;
 


@RestController
@RequestMapping(value="/client"  )
public class Client_Dashboard_controller {

	@Autowired
	DAOInterface2 DAOImpl;
	 
	@RequestMapping(value="/myProfile/{clientId}" ,method= RequestMethod.GET)
	Object MyProfileButtonClick (@PathVariable(name="clientId")String clientId ){
		System.out.println("MyProfileButtonClick handler method in Client_Dashboard_controller.java");
		Client client=DAOImpl.getAllClientByClientId(clientId);
		
		
		 return  client!=null? new ResponseEntity(client,HttpStatus.FOUND) 
				 : ResponseEntity.status(HttpStatus.OK).body(Map.of("message","no client with this clientId-> "+clientId));
  
 
	 
	}
	
	
	
	@RequestMapping(value="/myProject/{clientId}" ,method= RequestMethod.GET)
	Object MyProjectButtonClick (@PathVariable(name="clientId")String clientId){
		System.out.println("MyProjectButtonClick handler method in Client_Dashboard_controller.java");

		
		List<Object[]>l=DAOImpl.getAllProjectEveryColumnByClientId(clientId); 
		
		if(l!=null) {
		return new ResponseEntity(l,HttpStatus.FOUND);
		}
		return ResponseEntity.status(HttpStatus.OK).body(Map.of("message","no project for-> "+clientId));
	}
	
	

	
	@RequestMapping(value="/employeeOnMyProject/{clientId}" ,method= RequestMethod.GET)
	ResponseEntity EmployeeOnMYProjectButtonClick (@PathVariable(name="clientId")String clientId){
		System.out.println("EmployeeOnMYProjectButtonClick handler method in Client_Dashboard_controller.java"); 
		
		

		List<Object[]>l=DAOImpl.getAllEmployeeEveryColumnByClientId(clientId); 
		
		if(l!=null) {
			return new ResponseEntity(l,HttpStatus.FOUND);
			}
		Map<String, Object> map = new HashMap<>();
		List<String> messages = new ArrayList<>();

		messages.add("check one of these ->");
		messages.add("no employee is assigned for your project");
		messages.add("you don't have any project");
		messages.add("no client with this clientId -> " + clientId);

		map.put("messages", messages);
		return new ResponseEntity(map,HttpStatus.OK);
		}
	
}