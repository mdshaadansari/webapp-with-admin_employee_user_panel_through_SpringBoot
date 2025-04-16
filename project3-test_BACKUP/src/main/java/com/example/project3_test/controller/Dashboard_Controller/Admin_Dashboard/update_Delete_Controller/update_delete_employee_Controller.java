package com.example.project3_test.controller.Dashboard_Controller.Admin_Dashboard.update_Delete_Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.project3_test.DAO_Repository.DAOInterface2;
import com.example.project3_test.model.Employee;
 
/*
When you return a ResponseEntity<Object> from your method, Spring automatically uses message converters 
 to convert the response body into JSON. Since ResponseEntity holds the response body directly, 
 Spring assumes you want to send JSON if the client (like Postman) requests JSON.
You only need @RestController if you don’t want to use ResponseEntity explicitly but still want JSON responses.
*/
@Controller
@RequestMapping(path="/employee")

public class update_delete_employee_Controller {
	@Autowired
	DAOInterface2 DAOImpl;
	 

	@RequestMapping(path="/update/{employeeId}",method=RequestMethod.PUT)
	public Object  updateButtonClick(@RequestBody Employee employee,@PathVariable(name="employeeId")String employeeId) {
		
		System.out.println("updateButtonClick handler method in update_delete_employee_Controller.java");
	 	// updateing employee 
		Employee success=DAOImpl.updateEmployee(employee, employeeId);
		 

		 List l=new ArrayList();
		 l.add("employee not updated,possible reason ->");
		 l.add("no employee for employeeId-> "+employeeId);
		 
		 return success!=null?new ResponseEntity(success,HttpStatus.CREATED)
				 :ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message",l)); 
		
	}
	
	@RequestMapping(path="/delete/{employeeId}",method=RequestMethod.DELETE)
	public Object  DeleteButtonClick(@PathVariable(name="employeeId")String employeeId) {
		
		System.out.println("DeleteButtonClick handler method in update_delete_employee_Controller.java"); 
		 
		// deleting employee 
boolean success=DAOImpl.deleteEmployeeByEmployeeId(employeeId);
 


return success?ResponseEntity.status(HttpStatus.OK).body(Map.of("messgae",employeeId+" -> employee got deleted"))
		:new ResponseEntity(Map.of("messgae", employeeId+"->employee not deleted"),HttpStatus.BAD_REQUEST);



	}
	
}
