package com.example.project3_test.globalExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.project3_test.exception.emailExistException;
import com.example.project3_test.exception.noMember;
import com.example.project3_test.exception.requiredFields;

@ControllerAdvice
public class ControllerADVISE {

	@ResponseBody
	@ExceptionHandler({emailExistException.class})
	@ResponseStatus(value = HttpStatus.BAD_REQUEST )
	public Map<String, String> emailExsist(emailExistException e) {
		System.err.println("exception caught"); 
		Map<String,String> map=new HashMap();
		map.put("message", e.toString());
		return map;
		
	}
	
	
	
	 

	@ResponseBody
	@ExceptionHandler({requiredFields.class})

	@ResponseStatus(value = HttpStatus.BAD_REQUEST )
	public Map<String, String> requiredFields(requiredFields e) {
		
		
		Map<String,String> map=new HashMap();
		map.put("message", e.toString());
		return map;
	}
	
	
	
	
	
	
	@ResponseBody
	@ExceptionHandler({noMember.class}) 
	@ResponseStatus(value = HttpStatus.NOT_FOUND )
	public Map<String, String> noMember(noMember e) {
		
		
		Map<String,String> map=new HashMap();
		map.put("message", e.toString());
		return map;
	}
}
