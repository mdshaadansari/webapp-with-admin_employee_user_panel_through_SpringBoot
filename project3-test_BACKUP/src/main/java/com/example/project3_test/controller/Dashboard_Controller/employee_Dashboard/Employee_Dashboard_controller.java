package com.example.project3_test.controller.Dashboard_Controller.employee_Dashboard;

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
import com.example.project3_test.model.Employee;
 

@RestController
@RequestMapping(value="/employee"  )
public class Employee_Dashboard_controller {
	 

	@Autowired
	DAOInterface2 DAOImpl;
	 
	@RequestMapping(value="/myProfile/{employeeId}" ,method= RequestMethod.GET)
	Object MyProfileButtonClickinEmployeeDashboard (@PathVariable(name="employeeId")String employeeId){
		System.out.println("MyProfileButtonClickinEmployeeDashboard handler method in Employee_Dashboard_controller.java");
		
		Employee employee=DAOImpl.getAllEmployeeByEmployeeId(employeeId);
		
		
		if(employee!=null) {
		return ResponseEntity.status(HttpStatus.FOUND).body(employee);
		}
		return ResponseEntity.status(HttpStatus.OK).body(Map.of("message","no employee with this employeeId-> "+employeeId));
	 
	}
	
	
	
	@RequestMapping(value="/assignedOnProject/{employeeId}" ,method= RequestMethod.GET)
	ResponseEntity assignedOnProjectButtonClick (@PathVariable(name="employeeId")String employeeId){
		System.out.println("assignedOnProjectButtonClick handler method in Employee_Dashboard_controller.java");

		List<Object[]>l=DAOImpl.getAllProjectEveryColumnByemployeeId(employeeId);
		return l!=null? ResponseEntity.status(HttpStatus.FOUND).body(l)
				:new ResponseEntity(Map.of("message","no project assigned to employee-> "+employeeId),HttpStatus.OK) ;
 
	 
	}
	
	

	 
	
}