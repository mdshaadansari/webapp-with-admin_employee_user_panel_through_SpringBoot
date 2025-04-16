package com.example.project3_test.Service.Admin_Dashboard.addMemebers_Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project3_test.DAO_Repository.DAOInterface2;
import com.example.project3_test.Service.emailSender.emailSender;
import com.example.project3_test.exception.requiredFields;
import com.example.project3_test.idCreator.projectIdGenerator;
import com.example.project3_test.model.Project;
 
 
@Service
public class createProject_Service {

	@Autowired
	DAOInterface2 DAOImpl;
	
	@Autowired
	emailSender emailSender;
	 
	 
	 
	 
	public Project addProjectInDB_Service (Project project  ){
		System.out.println("addProjectInDB_Service   method in createProject_Service.java");
 

		// creating new projectId based on what is already availabe in DB, creating todays date sending back to adminDashboard.jsp 
	String	lastProjectIdFromProjectDB = DAOImpl.getLastProjectIDFromDB();
		if (lastProjectIdFromProjectDB != null) {
			System.out.println(lastProjectIdFromProjectDB + " is last projectId present in db");

		// ======(start)===incrimenting projectId which is coming from DB and send new projectId to admin.jsp=======
		lastProjectIdFromProjectDB = projectIdGenerator.generateNextId(lastProjectIdFromProjectDB);
		// ================================================================
		}else {
			lastProjectIdFromProjectDB="project-001";
		}
		 project.setProjectId(lastProjectIdFromProjectDB);
		 
		 
		 if(project.getProjectName()==null|project.getStartDate()==null|project.getEndDate()==null) {
			 throw new requiredFields();
		 }
		
		
		
		
		// inserting data in project table
		 Project success=DAOImpl.insertIntoProject(project);
		if((success!=null)) {
			System.out.println("Project  added successfully");

			return  success;
		}
 
		return null;
		 
		// =========================================================
	}
	
	
 
	
}