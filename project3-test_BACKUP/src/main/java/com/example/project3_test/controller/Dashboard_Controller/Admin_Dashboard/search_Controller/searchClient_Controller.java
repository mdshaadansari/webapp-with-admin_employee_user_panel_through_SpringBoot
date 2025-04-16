package com.example.project3_test.controller.Dashboard_Controller.Admin_Dashboard.search_Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.project3_test.DAO_Repository.DAOInterface2;
import com.example.project3_test.Service.emailSender.emailSender;
import com.example.project3_test.exception.noMember;
import com.example.project3_test.model.Client;
 
@Controller
@RequestMapping(path="/client" )
public class searchClient_Controller {

	@Autowired
	DAOInterface2 DAOImpl;
	
	@Autowired
	emailSender emailSender;

	
	@ResponseBody
	@RequestMapping(path="/all",method=RequestMethod.GET) 
	public ResponseEntity getAllClientButtonClick ( ) {
		
		 System.out.println("getAllClientButtonClick handler method in searchClient_Controller.java"); 
		 //getting all info. of client from client table
		 //can only fetch particular colum and left the column that are in assosiation mapping , so only all client will be fetch,
		 //not all info about tables that is in assosiation mapping, 
//		 like if we will return List<Object> what would me serving more meaning
		 List<Client>getAllClient=DAOImpl.getAllClient();
		 
		 if(getAllClient!=null) {
			 
							return new ResponseEntity(getAllClient,HttpStatus.OK);
					 
						}else{
							return new ResponseEntity(Map.of("message","no employee client"),HttpStatus.BAD_REQUEST);
						}
		 

			
		
		
	}
	@ResponseBody
	@RequestMapping(path="/{clientId}",method=RequestMethod.GET) 
	public ResponseEntity getAllProjectByClientIdButtonClienk  (@PathVariable (name="clientId") String clientId) {
		 System.out.println("getAllProjectByClientIdButtonClienk handler method in searchClient_Controller.java");
		 System.out.println(clientId);
		 
		  

			 //getting all project for particular clientId
			  List<Object[]>getAllProjectForClientId2=DAOImpl.getAllProjectForClientId2(clientId);
			 
			 if(getAllProjectForClientId2!=null) {
			  
								return new ResponseEntity( getAllProjectForClientId2,HttpStatus.FOUND);
							 }else{
								  //throw new noMember(); 
								 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message","not project for -> "+clientId));
				 			}
				 
		 
		 
		 
			
	}
}
