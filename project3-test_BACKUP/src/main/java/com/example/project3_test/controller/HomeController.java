package com.example.project3_test.controller;

import java.io.IOException; 

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	
	@ResponseBody
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String test( ) throws IOException{
	return "Bonjour Senior";
	}
}
