package com.example.project3_test.model ;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

//import jakarta.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
 

@Entity
@Table(name="project")
public class Project{

/*
| -> project-id [project id gets generated automatically in the given format [project-001 | project-002 ...]]
		| -> project-name 
		| -> project-start-date
		| -> project-end-date
		| -> client
		| -> employee
*/
	@Id
	@Column
private String projectId;
	@Column
private String projectName;
	@Column(name="projectDateOfStart")
private String startDate;
	@Column(name="projectDateOfEnd")
private String endDate;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "clientIdInProject", referencedColumnName = "clientid")
private Client clientIdInProject;

	@JsonManagedReference
	@OneToMany(mappedBy="projectIdInEmployee",cascade = CascadeType.ALL)
private List<Employee> employee;
 
	 
public Project(String projectName, String startDate, String endDate, Client clientIdInProject,
			List<Employee> employee) {
		super();
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.clientIdInProject = clientIdInProject;
		this.employee = employee;
	}
public Project(String projectId, String projectName, String startDate, String endDate, Client clientIdInProject,
			List<Employee> employee) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.clientIdInProject = clientIdInProject;
		this.employee = employee;
	}
public Project() {
		super();
	}
public Project(String projectId, String projectName, String startDate, String endDate) {
	super();
	this.projectId = projectId;
	this.projectName = projectName;
	this.startDate = startDate;
	this.endDate = endDate;
}
public String getProjectId() {
	return projectId;
}
public void setProjectId(String projectId) {
	this.projectId = projectId;
}
public String getProjectName() {
	return projectName;
}
public void setProjectName(String projectName) {
	this.projectName = projectName;
}
public String getStartDate() {
	return startDate;
}
public void setStartDate(String startDate) {
	this.startDate = startDate;
}
public String getEndDate() {
	return endDate;
}
public void setEndDate(String endDate) {
	this.endDate = endDate;
}
public Client getClientIdInProject() {
	return clientIdInProject;
}
public void setClientIdInProject(Client clientIdInProject) {
	this.clientIdInProject = clientIdInProject;
}
public List<Employee> getEmployee() {
	return employee;
}
public void setEmployee(List<Employee> employee) {
	this.employee = employee;
}  



}