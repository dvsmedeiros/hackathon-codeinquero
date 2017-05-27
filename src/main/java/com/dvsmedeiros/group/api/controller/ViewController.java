package com.dvsmedeiros.group.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
	
	@RequestMapping("/")
	public String index(){
	    return "index";
	}
	
	@RequestMapping("/groups")
	public String groups(){
	    return "groups";
	}
	
	@RequestMapping("/group")
	public String groupDetail(){
	    return "group";
	}
	
	@RequestMapping("/profile")
	public String profile(){
	    return "profile";
	}
	
}
