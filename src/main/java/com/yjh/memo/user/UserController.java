package com.yjh.memo.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@GetMapping("/signup/view")
	public String signupView() {
		return "user/signup";
		
	}
	
	@GetMapping("/signin/view")
	public String signinView() {
		return "user/signin";
	}
}
