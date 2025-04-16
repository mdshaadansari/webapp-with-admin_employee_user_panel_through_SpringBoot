package com.example.project3_test.model;

import javax.persistence.Column;
import javax.persistence.Entity;

//import jakarta.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "contactPerson")
 
public class ContactPerson {
 

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "contactPersonId")
public int contactPersonId ;

	@Column(name = "contactPersonName")
	private String contactPersonName;

	@Column(name = "email")
	private String contactPersonEmail;
	@Column(name = "phone")
	private String contactPersonPhone;

	@Column(name = "designation")
	private String contactPersonDesignation;

 
	 
//column will be maintained here  
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "clientIdInContactPerson", referencedColumnName = "clientid")
	private Client clientIdInContactPerson;
 
	
	 
	public ContactPerson(String contactPersonName, String contactPersonEmail, String contactPersonPhone,
		String contactPersonDesignation, Client clientIdInContactPerson) {
	super();
	this.contactPersonName = contactPersonName;
	this.contactPersonEmail = contactPersonEmail;
	this.contactPersonPhone = contactPersonPhone;
	this.contactPersonDesignation = contactPersonDesignation;
	this.clientIdInContactPerson = clientIdInContactPerson;
}

	public ContactPerson(int contactPersonId, String contactPersonName, String contactPersonEmail,
			String contactPersonPhone, String contactPersonDesignation, Client clientIdInContactPerson) {
		super();
		this.contactPersonId = contactPersonId;
		this.contactPersonName = contactPersonName;
		this.contactPersonEmail = contactPersonEmail;
		this.contactPersonPhone = contactPersonPhone;
		this.contactPersonDesignation = contactPersonDesignation;
		this.clientIdInContactPerson = clientIdInContactPerson;
	}

	public ContactPerson() {
		super();
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public int getContactPersonId() {
		return contactPersonId;
	}

	public void setContactPersonId(int contactPersonId) {
		this.contactPersonId = contactPersonId;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public String getContactPersonEmail() {
		return contactPersonEmail;
	}

	public void setContactPersonEmail(String contactPersonEmail) {
		this.contactPersonEmail = contactPersonEmail;
	}

	public String getContactPersonPhone() {
		return contactPersonPhone;
	}

	public void setContactPersonPhone(String contactPersonPhone) {
		this.contactPersonPhone = contactPersonPhone;
	}

	public String getContactPersonDesignation() {
		return contactPersonDesignation;
	}

	public void setContactPersonDesignation(String contactPersonDesignation) {
		this.contactPersonDesignation = contactPersonDesignation;
	}

	public Client getClientIdInContactPerson() {
		return clientIdInContactPerson;
	}

	public void setClientIdInContactPerson(Client clientIdInContactPerson) {
		this.clientIdInContactPerson = clientIdInContactPerson;
	}
 

}