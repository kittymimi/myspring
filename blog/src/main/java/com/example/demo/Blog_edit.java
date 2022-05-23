package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public class Blog_edit {
	
	@Autowired
	private BlogInfoRepository blogInfoRepository;
	
	@GetMapping("/blog_edit")
	public String getBlogView() {
		return "blog_edit";
	}
	
	@PostMapping("/blog_edit")
   	public ModelAndView blog(//
   			@RequestParam("id") String id, //
   			@RequestParam("title") String title, //
   			@RequestParam("content") String content, //
   			@RequestParam("edit") String edit, //
   			@RequestParam("image") String image, //
			ModelAndView mv) {
		mv.addObject("id", id);
		BlogInfo blogInfo = blogInfoRepository.findByID(id);	
		if (id.equals(blogInfo.getId())) {
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
