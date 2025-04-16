package com.example.project3_test.exception;

public class emailExistException extends RuntimeException{

	String email;
	public emailExistException(String email){
		this.email=email;
	}
	
	public String getMessage() {
		return " email already exist";
	}
	public String toString() {
		return "member with provided "+ email+getMessage();
	}
}
