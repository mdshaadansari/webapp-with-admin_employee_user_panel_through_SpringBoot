package com.example.project3_test.controller.Dashboard_Controller.Admin_Dashboard.assign_Controller;

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
import com.example.project3_test.model.Employee;
 
@Controller
@RequestMapping(path="/employee")
public class add$Release_EmployeeToProject_Controller {

	@Autowired
	DAOInterface2 DAOImpl;
	
	@Autowired
	emailSender emailSender;

	
@ResponseBody
	@RequestMapping(path="/assign/{employeeId}/{projectId}" ,method=RequestMethod.PUT)
	public Object addEmployeeToProjectServlet_step3(@PathVariable(name = "employeeId")String employeeId, @PathVariable(name = "projectId")String projectId) {
	System.out.println( "addEmployeeToProjectServlet_step3 handeler method in add$Release_EmployeeToProject_Controller.java");
	 
		//==========================first check is that for particular empoyee any project is assigned already 
		//if yes then sending message that employee already is in project 
		//else assigning project
		
		//List to store employee already assigned to project
		String employeeIdOfEmployeeWhoIsAlreadyAssignedToSomeProject=null;
		String employeeNameOfEmployeeWhoIsAlreadyAssignedToSomeProject=null;
		String projectIdInEmployeeOfEmployeeWhoIsAlreadyAssignedToSomeProject=null; 
		List<String> checkEmployeeOnBenchOrNot=DAOImpl.checkEmployeeOnBenchOrNot(employeeId);
		
		if(checkEmployeeOnBenchOrNot!=null) {
			employeeNameOfEmployeeWhoIsAlreadyAssignedToSomeProject=checkEmployeeOnBenchOrNot.get(0);
			employeeIdOfEmployeeWhoIsAlreadyAssignedToSomeProject=checkEmployeeOnBenchOrNot.get(1);
			projectIdInEmployeeOfEmployeeWhoIsAlreadyAssignedToSomeProject=checkEmployeeOnBenchOrNot.get(2);
 		return Map.of(employeeIdOfEmployeeWhoIsAlreadyAssignedToSomeProject ,"is already assigned to project-> "+projectIdInEmployeeOfEmployeeWhoIsAlreadyAssignedToSomeProject);
			 
			
			}else { 
		//==============inserting projectId in employee table in projectIdInEmployee column when no project is assigned to employee
				System.out.println("employee is not assigned to any project so assigning employee to project");
		 
				Employee	success=DAOImpl.assiginProjectToEmployee(projectId, employeeId);
		
		//=========if project assigned successfully send message back 
		  	return ResponseEntity.status(HttpStatus.ACCEPTED).body(success);
			  
			 
			 
			}
	 
		
		
	}
	
	
@ResponseBody
	@RequestMapping(path="/release/{employeeId}/{projectId}", method=RequestMethod.PUT)
	ResponseEntity addingEmployeeToProject_step2_releaseButtonClientServlet(@PathVariable(name="projectId") String projectId,
			@PathVariable(name="employeeId") String employeeId		) {
	System.out.println( "addingEmployeeToProject_step2_releaseButtonClientServlet handeler method in add$Release_EmployeeToProject_Controller.java");
 
	// ==========releasing employee from project
 
	Employee employee = DAOImpl. releaseEmployeeFromProject(employeeId,projectId);
		if(employee!=null) {
			System.out.println("yes, employee released from project"); 
			 
			return ResponseEntity.status(HttpStatus.OK).body(employee);
			
		}else {
			System.out.println("no, employee not released from project");
			throw new noMember();
			
		}
	 

	}
	
}
