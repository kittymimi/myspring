package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.UserInfo;
import com.example.demo.UserInfoRepository;

@Controller
public class Register {

	@Autowired
	private UserInfoRepository userInfoRepository;

	@GetMapping("/register")
	public String getRegisterView() {
		return "register";
	}

	@PostMapping("/register")
	public ModelAndView register(//
			@RequestParam("username") String username, //
			@RequestParam("password1") String password, //
			@RequestParam("password2") String passwordAgain, //
			ModelAndView mv) {
		if (!password.equals(passwordAgain)) {
			mv.setViewName("fail_register");		
		} else {
			UserInfo userInfo = UserInfo.builder()//
					.name(username)//
					.password(password)//
					.build();
			userInfoRepository.save(userInfo);
			mv.addObject("username", username);
			mv.setViewName("login");
		}
		return mv;
	}
}