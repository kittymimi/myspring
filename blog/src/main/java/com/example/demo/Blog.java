package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
   			@RequestParam("username") String username,//
   			@RequestParam("title") String title, //
   			@RequestParam("content") String content, //
			ModelAndView mv) {
  		BlogInfo blogInfo = BlogInfo.builder()//
  				.username(username)//
  				.title(title)//
				.content(content)//
				.build();
  		blogInfoRepository.save(blogInfo);
  		mv.addObject("username", username);
		mv.addObject("title", title);
		mv.addObject("content", content);
		mv.setViewName("submit");
		return mv;
	}
  	
  	@PostMapping("/update")
	public ModelAndView update(//
			@RequestParam("blogId") Long blogId,//
			@RequestParam("username") String username,//
   			@RequestParam("title") String title, //
   			@RequestParam("content") String content, //
			ModelAndView mv) {
  		BlogInfo blogInfo = blogInfoRepository.findByBlogId(blogId);
  		blogInfo.setUsername(username);
		blogInfo.setTitle(title);
		blogInfo.setContent(content);
		blogInfoRepository.save(blogInfo);
		mv.setViewName("submit_update");
		return mv;
	}
  	
  	@PostMapping("/delete")
	public ModelAndView delete(//
			@RequestParam("blogId") Long blogId,//
			ModelAndView mv) {
  		blogInfoRepository.deleteById(blogId);
		mv.setViewName("submit_delete");		
		return mv;
	}
  	
	@GetMapping("/comment")
	public String getUpdateView() {
		return "comment";
	}
  	
  	@PostMapping("/comment")
	public ModelAndView comment(//
			@RequestParam("blogId") Long blogId,//
   			@RequestParam("comment") String comment, //
			ModelAndView mv) {
  		BlogInfo blogInfo = blogInfoRepository.findByBlogId(blogId);
  		blogInfo.setComment(comment);
  		blogInfoRepository.save(blogInfo);
		mv.setViewName("submit_comment");
		return mv;
  	} 	
}
