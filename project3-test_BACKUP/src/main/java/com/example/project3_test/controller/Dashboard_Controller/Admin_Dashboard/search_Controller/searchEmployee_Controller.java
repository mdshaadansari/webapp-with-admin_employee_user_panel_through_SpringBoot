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
import com.example.project3_test.model.Employee;
 
@Controller

@RequestMapping(path="/employee" )
public class searchEmployee_Controller {

	@Autowired
	DAOInterface2 DAOImpl;
	 
	
	@ResponseBody
	@RequestMapping(path="/all",method=RequestMethod.GET)
	public ResponseEntity  getAllEmployeeButtonClienk  ( ) {
		 System.out.println("getAllEmployeeButtonClienk handler method in searchEmployee_Controller.java");
			 
		 //can only fetch particular colum and left the column that are in assosiation mapping , so only all client will be fetch,
		 //not all info about tables that is in assosiation mapping, 
//		 like if we will return List<Object> what would me serving more meaning
		
List<Employee>getAllEmployeeEveryColumn=DAOImpl.getAllEmployeeEveryColumn();
if(getAllEmployeeEveryColumn!=null){
	 
						return new ResponseEntity (getAllEmployeeEveryColumn,HttpStatus.FOUND) ;
					}else{ 
						 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message","no employee available"));
							 
					}
	}
	
	
	@ResponseBody
	@RequestMapping(path="/byEmail/{employeeEmail}",method=RequestMethod.GET)	
	public ResponseEntity  getAllEmployeeByEmailButtonClienk   (@PathVariable(name="employeeEmail")String employeeEmail) {
		 System.out.println("getAllEmployeeByEmailButtonClienk handler method in searchEmployee_Controller.java");

		  
		 
			 
			List <Object[]>getAllEmployeeByEmployeeEmail=DAOImpl.getAllEmployeeByEmployeeEmail(employeeEmail);
			if(getAllEmployeeByEmployeeEmail!=null) {
			 
							return new ResponseEntity(getAllEmployeeByEmployeeEmail,HttpStatus.FOUND);
						}else{
							
							
							 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message","no employee available for-> "+employeeEmail));
						}
		 
				
			
	}
	
	
	
	
	
	
	
	 
	@ResponseBody
	@RequestMapping(path="/byId/{employeeId}",method=RequestMethod.GET)	
	public ResponseEntity  getAllEmployeeByEmployeeIdButtonClienk (@PathVariable(name="employeeId")String employeeId) {
		 System.out.println("getAllEmployeeByEmployeeIdButtonClienk handler method in searchEmployee_Controller.java");
		 
  

			
			Employee getAllEmployeeByEmployeeId=DAOImpl.getAllEmployeeByEmployeeId(employeeId);
			if(getAllEmployeeByEmployeeId!=null) { 

				return new ResponseEntity(getAllEmployeeByEmployeeId,HttpStatus.FOUND);
			}else{
				
				
				 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message","no employee available for-> "+employeeId));
			} 
	}
	
	
	 
	@ResponseBody
	@RequestMapping(path="/getProjectByEmployeeId/{employeeId}",method=RequestMethod.GET)	 
	public ResponseEntity   getPrjectAssignedToEmployee  (@PathVariable(name="employeeId")String employeeId) {
		 System.out.println("getPrjectAssignedToEmployee handler method in searchEmployee_Controller.java"); 
			  List<Object[]> getEmployeeAndProjectByEmployeeId=DAOImpl.getEmployeeAndProjectByEmployeeId(employeeId);
			  if(getEmployeeAndProjectByEmployeeId!=null) {
				 	 

					return   ResponseEntity.status( HttpStatus.FOUND).body(getEmployeeAndProjectByEmployeeId);
							 }else{
								 System.err.println("when their is no project assigned to employee");
									
								 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message","no project assigned to employee-> "+employeeId));
							
				 			}
				 
				 
	}
	
	
	
	

	@ResponseBody
	@RequestMapping(path="/bench",method=RequestMethod.GET)	  
	public Object    getAllEmployeeOnBenchButtonClienk   ( ) {
		 System.out.println("getAllEmployeeOnBenchButtonClienk handler method in searchEmployee_Controller.java");
	 
			List<Object[]>getEmployeeOnBench=DAOImpl.getEmployeeOnBench();
			if(getEmployeeOnBench!=null) {
			 	
							return ResponseEntity.status(HttpStatus.FOUND).body(getEmployeeOnBench);
						}else{ 
							return new ResponseEntity(Map.of("message","no employee on beanch, every one is accha baccha"),HttpStatus.OK);
						}
		 
	}

}
