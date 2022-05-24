package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class Login {
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@GetMapping("/login")
	public String getLoginView() {
		return "login";
	}
	
  	@PostMapping("/login")
   	public ModelAndView login(//
   			@RequestParam("username") String username, //
   			@RequestParam("password") String password, //
			ModelAndView mv) {
		mv.addObject("username", username);
		UserInfo userInfo = userInfoRepository.findByName(username);	
		if (username.equals(userInfo.getUsername()) && password.equals(userInfo.getPassword())) {
			mv.setViewName("blog");
		} else {
			mv.setViewName("fail");
		}
		return mv;
	}
	
	@GetMapping("/blog")
	public String getSuccessView() {
		return "blog";
	}
}
