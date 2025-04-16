package com.example.project3_test.Service.Admin_Dashboard.addMemebers_Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project3_test.DAO_Repository.DAOInterface2;
import com.example.project3_test.Service.emailSender.emailSender;
import com.example.project3_test.exception.emailExistException;
import com.example.project3_test.exception.requiredFields;
import com.example.project3_test.idCreator.employeeIdGenerator;
import com.example.project3_test.model.Employee; 

 
@Service
public class createEmployee_Service {

	@Autowired
	DAOInterface2 DAOImpl;
	
	@Autowired
	emailSender emailSender;
	 
	
	 
	public Employee addEmployeeInDB_Service ( Employee employee){
		System.out.println("addEmployeeInDB_Service   method in createEmployee_Service.java");

 
		
		// ==getting employeeEmail in DB and matching it with incoming email==============
 				
				System.out.println("checking is that email is already in DB\t"+employee.getEmployeeEmail());
				boolean emailexsist=DAOImpl.checkemployeeEmail(employee.getEmployeeEmail());
				if (emailexsist==true) {
throw new emailExistException(employee.getEmployeeEmail());
				 
				  
			}
				if (employee.getEmployeeDOJ()==null||employee.getEmployeeEmail()==null||employee.getEmployeeDept()==null						||employee.getEmployeeName().isBlank()||employee.getEmployeePhone().isBlank()
						) { 
					throw new requiredFields();
							 	  
								} 
				
				
				//getting last employee id from db
				 String lastemployeeId=DAOImpl.getLastEmpoyeeIDFromDB();
				 
				 if(lastemployeeId==null) {
					 lastemployeeId="JTC-001";
				 }else {

				  //======(start)===incrimenting employeeId which is coming from DB=======
				 lastemployeeId=employeeIdGenerator.generateNextId( lastemployeeId);
				  //================================================================
				 }
				 
				//inserting employee in DB
				 employee.setEmployeeId(lastemployeeId);
				Employee success=DAOImpl.insertIntoEmployee(employee); 
				if( (success==null)) { 
					return null;
				}
			 
					
					return success;
				 
			}

 
	  
	
 
	
}