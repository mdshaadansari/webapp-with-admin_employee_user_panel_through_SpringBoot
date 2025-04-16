package com.example.project3_test.exception;

public class noMember extends RuntimeException{
 
	public noMember( ){ 
	}
	
	public String getMessage() {
		return " no Member for given data";
	}
	public String toString() {
		return  getMessage();
	}
}
