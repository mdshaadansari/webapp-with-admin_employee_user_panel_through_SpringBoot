package com.example.project3_test.exception;

public class requiredFields extends RuntimeException{
 
	public requiredFields(){
		
	}
	
	public String getMessage() {
		return "you did not provided mandatory fields";
	}
	public String toString() {
		return   getMessage();
	}
}
