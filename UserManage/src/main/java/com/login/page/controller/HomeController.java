package com.login.page.controller; 

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.login.page.model.UserDtls;
import com.login.page.service.UserService;

@Controller
public class HomeController {
	
	
	@Autowired
	private UserService userService;
	
	
	
	@GetMapping("/")
	public String index() {
		
		
		return "index" ;
		
	}
	
	@GetMapping("/signin")
	public String login() {
		
		System.out.println("login pass");
		
		return "login" ;
		
	}
	
	@GetMapping("/register")
	public String register() {
		
		
		return "register" ;
		
	}
	
	
	@PostMapping("/createUser")
	public String createuser(@ModelAttribute UserDtls user  ,HttpSession session) {
		
		      
		
	  System.out.println(user);
	  
	  boolean AlreadyUser =userService.checkEmail(user.getEmail());
	  
	  if(AlreadyUser) {
		  
		  session.setAttribute("msg" ,"Email id already exists");
			System.out.println("Email id already exist");
		  
	  }
	  else {
	  
	  
		UserDtls userDtls =userService.createUser(user);
		if (userDtls !=null) {
			
			session.setAttribute("msg" ,"Register Successfull");
			System.out.println("Register Successfull");
		}else {
			
			
			session.setAttribute("msg" ,"Something wrong on server");
			System.out.println("Something wrong on server");
			
		}
	  }
		
		
		return "redirect:/register";	
	//	return "register"; // Getting same data when the refreshing the page
	}
	
	
	
	
	

}
