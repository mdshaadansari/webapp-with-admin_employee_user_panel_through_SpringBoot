package com.example.project3_test.model; 
 
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import jakarta.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

 
@Entity
@Table(name="client")
public class Client { 
	@Id
	@Column(name="clientid")
private String clientID;
	@Column
private String clientName;
	@Column
private String emailClient;
	@Column
private String clientRelationshaipDate;

	@JsonManagedReference
@OneToMany(mappedBy = "clientIdInContactPerson", cascade = CascadeType.ALL)
private List<ContactPerson> contactPerson;
 
	@JsonManagedReference
@OneToMany(mappedBy = "clientIdInProject",cascade = CascadeType.ALL)
private List<Project> project;
 
	

public List<ContactPerson> getContactPerson() {
	return contactPerson;
}


public void setContactPerson(List<ContactPerson> contactPerson) {
	this.contactPerson = contactPerson;
}


public List<Project> getProject() {
	return project;
}


public void setProject(List<Project> project) {
	this.project = project;
}


public Client(String clientID, String clientName, String emailClient, String clientRelationshaipDate) {
	super();
	this.clientID = clientID;
	this.clientName = clientName;
	this.emailClient = emailClient;
	this.clientRelationshaipDate = clientRelationshaipDate;
}
 

public Client(String clientName, String emailClient, String clientRelationshaipDate,
		List<ContactPerson> contactPerson) {
	super();
	this.clientName = clientName;
	this.emailClient = emailClient;
	this.clientRelationshaipDate = clientRelationshaipDate;
	this.contactPerson = contactPerson;
}


public Client() {
	super();
}


public String getClientID() {
	return clientID;
}


public void setClientID(String clientID) {
	this.clientID = clientID;
}


public String getClientName() {
	return clientName;
}


public void setClientName(String clientName) {
	this.clientName = clientName;
}


public String getEmailClient() {
	return emailClient;
}


public void setEmailClient(String emailClient) {
	this.emailClient = emailClient;
}


public String getClientRelationshaipDate() {
	return clientRelationshaipDate;
}


public void setClientRelationshaipDate(String clientRelationshaipDate) {
	this.clientRelationshaipDate = clientRelationshaipDate;
}

 
 
  

 
 

 

/*
//@ManyToOne
//@JoinColumn(name="projectId", referencedColumnName="projectId")
//column will be maintained here
 private project project;
*/
}