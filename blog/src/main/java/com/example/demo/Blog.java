package com.example.demo;


import java.util.List;
import java.util.Map; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.BlogInfo;
import com.example.demo.UserInfo;


@Controller
public class Blog {
	
	@Autowired
	private BlogInfoRepository blogInfoRepository;
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@GetMapping("/editor")
	public ModelAndView blog(@RequestParam("username") String username, Map<String, Object> map, ModelAndView mv) {
		map.put("username", username);
		mv.addObject("blogList", blogInfoRepository.findAll());
		mv.setViewName("editor");
		return mv; 
	}
  	@PostMapping("/submit")
   	public ModelAndView submit(//
   			@RequestParam("username") String username, //
   			@RequestParam("title") String title, //
   			@RequestParam("contents") String contents, //
			ModelAndView mv) {
  		mv.addObject("username", username);
  		BlogInfo blogInfo = BlogInfo.builder()//
  				.title(title)//
				.contents(contents)//
				.build();
  		blogInfoRepository.save(blogInfo);
		mv.addObject("username", username);
		mv.addObject("title", title);
		mv.addObject("contents", contents);
		mv.setViewName("submit");
		
		return mv;
	}
	

}