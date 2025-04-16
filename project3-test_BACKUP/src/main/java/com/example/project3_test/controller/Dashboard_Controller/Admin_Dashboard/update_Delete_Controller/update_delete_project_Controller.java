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
import com.example.project3_test.model.Project;
 
@Controller

@RequestMapping(path="/project")
public class update_delete_project_Controller {
	@Autowired
	DAOInterface2 DAOImpl;


	
	

	@RequestMapping(path="/update/{projectId}",method=RequestMethod.PUT)
	public Object  updateButtonClick(@RequestBody Project project,@PathVariable(name="projectId")String projectId) {
		System.out.println("updateButtonClick handler method in update_delete_project_Controller.java"); 
 
		// updateing project
		Project Project =DAOImpl.updateProject(project, projectId);

		 List l=new ArrayList();
		 l.add("project not updated,possible reason ->");
		 l.add("no project for projectId-> "+projectId);
		 
	 return Project!=null?new ResponseEntity(Project,HttpStatus.CREATED)
	: ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message",l)); 
	}
	
	
	
	@RequestMapping(path="/delete/{projectId}",method=RequestMethod.DELETE)
	public Object  DeleteButtonClick(@PathVariable(name="projectId")String projectId) {
		System.out.println("DeleteButtonClick handler method in update_delete_project_Controller.java"); 

		// deleting employee
		boolean success =DAOImpl.deleteProjectByProjectId(projectId);

return success?ResponseEntity.status(HttpStatus.OK).body(Map.of("messgae",projectId+" -> project got deleted"))
		:new ResponseEntity(Map.of("messgae", projectId+"->project not deleted"),HttpStatus.BAD_REQUEST);



	}
	
}
