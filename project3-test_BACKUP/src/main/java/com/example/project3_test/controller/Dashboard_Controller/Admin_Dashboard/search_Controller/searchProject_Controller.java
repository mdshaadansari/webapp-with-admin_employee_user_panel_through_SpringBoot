package com.example.project3_test.controller.Dashboard_Controller.Admin_Dashboard.search_Controller;

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
import com.example.project3_test.model.Project;
 
@Controller

@RequestMapping(path="/project")
public class searchProject_Controller {

	@Autowired
	DAOInterface2 DAOImpl;
	  
@ResponseBody
	@RequestMapping(path="/all",method=RequestMethod.GET)
	public Object getAllProjectButtonClienk ( ) { 
	
		 //fetchingg all project column from db 
		 List<Project>getAllProjectEveryColumn=DAOImpl.getAllProjectEveryColumn();
		 
		 if(getAllProjectEveryColumn!=null) {
			 
							return new ResponseEntity (getAllProjectEveryColumn,HttpStatus.FOUND);
						 }else{
							 return ResponseEntity.status(HttpStatus.OK).body(Map.of("message","no project available in db"));
			 			} 
	}
	

@ResponseBody
	@RequestMapping(path="/byId/{projectId}",method=RequestMethod.GET)
	public Object getAllProjectByProjectIdButtonClienk  (@PathVariable(name="projectId")String projectId) {
		 System.out.println("getAllProjectByProjectIdButtonClienk handler method in searchProject_Controller.java");
		  
			 //fetchingg all project column from db 
			 List<Object[]>getAllProjectEveryColumnByProjectId=DAOImpl.getAllProjectEveryColumnByProjectId(projectId);

			 if(getAllProjectEveryColumnByProjectId!=null) {
				 
								return ResponseEntity.status(HttpStatus.FOUND).body(getAllProjectEveryColumnByProjectId);
							 }else{
								return new ResponseEntity(Map.of("message","no project for projectid-> "+projectId),HttpStatus.OK);
				 			}
				 
				
			
	}
	
	
	
	
	
	
	
	
	
	

@ResponseBody
	@RequestMapping(path="/getClientByProjectId/{projectId}",method=RequestMethod.GET) 
	public Object getAllClientByProjectIdButtonClick (@PathVariable(name="projectId")String projectId) {
		 System.out.println("getAllClientByProjectIdButtonClick handler method in searchProject_Controller.java");
		   
			 
			 //getting all client details from DB based on projectId 
			 List<Object[]> getAllClientByProjectId=DAOImpl.getAllClientByProjectId(projectId);
			 if(getAllClientByProjectId!=null) {
			 				 
					return ResponseEntity.status(HttpStatus.FOUND).body(getAllClientByProjectId);
			 }else{
				return new ResponseEntity(Map.of("message","no client for projectid-> "+projectId),HttpStatus.OK);
 			}
			 	
	}
	
	
	
	

@ResponseBody
@RequestMapping(path="/allEmployeeByProjectId/{projectId}",method=RequestMethod.GET) 
	public Object  getAllEmployeeByProjectIdButtonClick (@PathVariable(name="projectId")String projectId) {
		 System.out.println("getAllEmployeeByProjectIdButtonClick handler method in searchProject_Controller.java");
 
			 
		 List<Object[]>getAllEmployeeEveryColumnByProjectId=DAOImpl.getAllEmployeeEveryColumnByProjectId(projectId);
			 if(getAllEmployeeEveryColumnByProjectId!=null) {
			 
						 
			 
				return ResponseEntity.status(HttpStatus.FOUND).body(getAllEmployeeEveryColumnByProjectId);
}else{
	 System.err.println("when their is on employee on the basis of projectId");
		
	return new ResponseEntity(Map.of("message","no client for projectid-> "+projectId),HttpStatus.OK);
}
				 
	}
}
