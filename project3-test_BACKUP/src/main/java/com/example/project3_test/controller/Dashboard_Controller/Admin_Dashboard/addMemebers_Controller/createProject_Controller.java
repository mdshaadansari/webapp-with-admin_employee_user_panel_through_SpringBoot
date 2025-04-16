package com.example.project3_test.controller.Dashboard_Controller.Admin_Dashboard.addMemebers_Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.project3_test.DAO_Repository.DAOInterface2;
import com.example.project3_test.Service.Admin_Dashboard.addMemebers_Service.createProject_Service;
import com.example.project3_test.Service.emailSender.emailSender;
import com.example.project3_test.model.Project;
 
 
@Controller

@RequestMapping(path="/project")
public class createProject_Controller {

	@Autowired
	DAOInterface2 DAOImpl;
	
	@Autowired
	emailSender emailSender;
	
	@Autowired
	createProject_Service createProject_Service;
	/*
	@RequestMapping(value="/addProjectButtonClick" ,method= RequestMethod.GET)
	String addProjectButtonClick (HttpSession session ){
		System.out.println("addProjectButtonClick handler method in createProject_Controller.java");
 
		// ==getting last projectId from project DB and sending to adminDashboard.jsp==============
		String lastProjectIdFromProjectDB =DAOImpl. getLastProjectIDFromDB();
		if(lastProjectIdFromProjectDB!=null) {
		System.out.println("last project from DB is " + lastProjectIdFromProjectDB);

		//======(start)===incrimenting projectId which is coming from DB=======
		lastProjectIdFromProjectDB=projectIdGenerator.generateNextId(lastProjectIdFromProjectDB);
		//================================================================
		System.out.println("new project genrated " + lastProjectIdFromProjectDB);
		java.time.LocalDate l=  java.time.LocalDate.now();
		String s=l.getDayOfMonth()+"-"+ l.getMonth() +"-"+ l.getYear();
		

		session.setAttribute("comingFromaddProjectButtonClick","comingFromaddProjectButtonClick");
		session.setAttribute("projectId", lastProjectIdFromProjectDB);
		session.setAttribute("projectDateOfStart", s);
		 
		return "adminDashboard";
		 

		// =======if no project is not in DB then creating first projectId and sending to
		// adminDashboard.jsp========

	} else {
		String projectId = "project-001";
		java.time.LocalDate l=  java.time.LocalDate.now();
		String s=l.getDayOfMonth()+"-"+ l.getMonth() +"-"+ l.getYear();
		
		System.out.println("no project in DB ,so creating new projectId "+projectId);
		session.setAttribute("comingFromaddProjectButtonClick", "comingFromaddProjectButtonClick");
		session.setAttribute("projectId", projectId);
		session.setAttribute("projectDateOfStart", s);
		 
			return "adminDashboard" ;
	 
	}

 
// =========================================================
 
	 
	}
	*/
	
	
	@RequestMapping( method= RequestMethod.POST)
	ResponseEntity<Project> addProjectInDB (@RequestBody Project project  ){

			System.out.println("addProjectInDB handler method in createProject_Controller.java");
		   
		// inserting data in project table
			Project result=createProject_Service.addProjectInDB_Service(project);
		
		if(result!=null ) {
			return new ResponseEntity(result,HttpStatus.CREATED);
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	
 
	
}