package com.example.project3_test.Service.Admin_Dashboard.addMemebers_Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project3_test.DAO_Repository.DAOInterface2;
import com.example.project3_test.Service.emailSender.emailSender;
import com.example.project3_test.exception.emailExistException;
import com.example.project3_test.exception.requiredFields;
import com.example.project3_test.idCreator.clientIdGenerator;
import com.example.project3_test.model.Client;
 
@Service
public class createClient_Service {

	@Autowired
	DAOInterface2 DAOImpl;
	 

 	@Autowired
	emailSender emailSender;
	

		// =========================================================
 
	  
	
	
 	// =======  storing incoming client details and ContactPerson in DB=====
	public Client addClientInDB_Service ( Client client){  
System.err.println("addClientInDB_Service method in  createClient_Service.java");  
		 
//checking if email already exist
List<String> clientdetails=DAOImpl.checkClientEmail(client.getEmailClient());

if(clientdetails!=null){
	System.err.println("Duplicate email detected: " + client.getEmailClient());
 

	throw new emailExistException(client.getEmailClient());
}

 

//==getting last clientId from client DB 
String lastClientIdFromClientDB=DAOImpl.getLastClientIDFromDB();
if(lastClientIdFromClientDB!=null) {
	System.out.println("last clientId from DB is " + lastClientIdFromClientDB);

	//======(start)===incrementing clientId which is coming from DB=======
	lastClientIdFromClientDB=clientIdGenerator.generateNextId(lastClientIdFromClientDB);
	//================================================================
	System.out.println("new clientId genrated " + lastClientIdFromClientDB); 
	client.setClientID(lastClientIdFromClientDB);
	}else{
		String clientId = "client-001"; 
		client.setClientID(clientId);
		//==if client id not avilable in db then   
	}
	
	if(client.getClientID()==null||client.getClientName()==null||client.getEmailClient()==null||client.getClientRelationshaipDate()==null||client.getContactPerson()==null) {

		throw new requiredFields();
	}
	
			Client success=	DAOImpl.insertIntoClient(client);
			 
				 if(success!=null) {

						///sending login credentials to client email and contact person
					System.out.println("sending email");
						emailSender.sendEmail(success.getEmailClient(), success.getClientName()+" you have joined by admin", "Login with your email " );
//						emailSender.sendEmail( contactPersonEmail, "welcome "+contactPersonName, client_name+" added you as contact person ");
						System.out.println("email sent");	
						return success;
						
				 }
				 
						return success;
					 
			 
		// =========================================================


 
	 
	}
	
	
 
	
}