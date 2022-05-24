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
	
	@GetMapping("/editor")
	public String getEditorView() {
		return "editor";
	}
	
  	@PostMapping("/editor")
   	public ModelAndView submit(//
   			@RequestParam("title") String title, //
   			@RequestParam("content") String content, //
			ModelAndView mv) {
  		BlogInfo blogInfo = BlogInfo.builder()//
  				.title(title)//
				.content(content)//
				.build();
  		blogInfoRepository.save(blogInfo);
		mv.addObject("title", title);
		mv.addObject("content", content);
		mv.setViewName("submit");	
		return mv;
	}
}
