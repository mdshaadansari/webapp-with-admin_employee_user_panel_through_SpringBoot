package com.example.project3_test.controller.Dashboard_Controller.Admin_Dashboard.assign_Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.project3_test.DAO_Repository.DAOInterface2;
import com.example.project3_test.Service.emailSender.emailSender;
import com.example.project3_test.model.Client;
 
@Controller 
@RequestMapping(path="/clientTOProject")
public class addProjectToClient_Controller {
	@Autowired
	DAOInterface2 DAOImpl;
	
	@Autowired
	emailSender emailSender;

	@ResponseBody
	@RequestMapping(path="/{projectId}/{clientId}" ,method=RequestMethod.PUT) 
	public Object addProjectToClientServlet_step3( @PathVariable(name="projectId") String projectId,@PathVariable(name="clientId") String clientId) {
		System.out.println("addProjectToClientServlet_step3 handeler method in addProjectToClient_Controller.java");
		   
		//==========================first check is that for particular project any client is their already 
		//if yes then sending message that project has client 
		//else assigning client to project
		
		//List to store project having client
		String projectIdOfProjectWhichAlreadyHaveClient=null;
		String projectNameOfProjectWhichAlreadyHaveClient=null;
		String clientIdInProjectOfClientWhichAlreadyHaveProject=null;
		
		 
		List<String> checkProjectAssignedToClientOrNot=DAOImpl.checkProjectAssignedToClientOrNot(projectId);
		if(checkProjectAssignedToClientOrNot!=null) {
			projectIdOfProjectWhichAlreadyHaveClient=checkProjectAssignedToClientOrNot.get(0);
			projectNameOfProjectWhichAlreadyHaveClient=checkProjectAssignedToClientOrNot.get(1);
			clientIdInProjectOfClientWhichAlreadyHaveProject=checkProjectAssignedToClientOrNot.get(2);
		
		 	
	System.out.println(" not project assigning  to client and sending back to addingProjectToClient.jsp ");
 
					return  Map.of(projectIdOfProjectWhichAlreadyHaveClient+" project belongs to -> ",clientIdInProjectOfClientWhichAlreadyHaveProject);
				 
			}else { 
		//==============inserting clientId in project table in clientIdInProject column
				//when client has no project
				System.out.println("client has no project so assigning"); 
				Client client=DAOImpl.assignProjectToClient(clientId, projectId); 
		//=========if client assigned successfully send message back 
				return  client; 
			} 
	
		
	}
	
	 
	
}
