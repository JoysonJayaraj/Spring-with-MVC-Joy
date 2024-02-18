package com.te.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/app")
@Controller
public class ApplicationController {
	
	// this is void method 
//		@RequestMapping(path = "/welcome")
//		public void welcome() {
//			System.out.println("we reached here!");
//		}
	
	@RequestMapping(path = "/welcome")
	public String welcome() {
		System.out.println("we reached here!");
		return "welcome";
	}
	
	
	@RequestMapping(path = "/contact")
	public String contact() {
		System.out.println("Contact me page Done");
		return "contact";
	}
	
}
