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
import com.example.project3_test.model.Client;
 

/*
When you return a ResponseEntity<Object> from your method, Spring automatically uses message converters 
 to convert the response body into JSON. Since ResponseEntity holds the response body directly, 
 Spring assumes you want to send JSON if the client (like Postman) requests JSON.
You only need @RestController if you don’t want to use ResponseEntity explicitly but still want JSON responses.
*/
@Controller
@RequestMapping(path={"/client"})
public class update_delete_client_Controller {
	@Autowired
	DAOInterface2 DAOImpl;
	  
	@RequestMapping(path="/update/{clientId}",method=RequestMethod.PUT) 
	public Object  updateButtonClick(@PathVariable(name="clientId")String clientId,@RequestBody Client client) {
		System.out.println("updateButtonClick handler method in update_delete_client_Controller.java");
	 
		// updateing client 
 Client Client= DAOImpl.updateClient(client, clientId);
  
 List l=new ArrayList();
 l.add("client not updated,possible reason ->");
 l.add("no client for clientId-> "+clientId);
 
 return Client!=null?new ResponseEntity(Client,HttpStatus.CREATED)
		 :ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message",l)); 
	}
	
	
	
	@RequestMapping(path="/delete/{clientId}",method=RequestMethod.DELETE) 
	public Object  DeleteButtonClick(@PathVariable(name="clientId")String clientId) {
		System.out.println("DeleteButtonClick handler method in update_delete_client_Controller.java"); 

		// deleting client
		boolean success =DAOImpl.deleteclient(clientId);
	 
		return success?ResponseEntity.status(HttpStatus.OK).body(Map.of("messgae",clientId+" -> client got deleted"))
				:new ResponseEntity(Map.of("messgae", clientId+"->client not deleted"),HttpStatus.BAD_REQUEST);

	}
	
}
