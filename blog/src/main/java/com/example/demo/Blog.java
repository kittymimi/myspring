package com.example.demo;


import java.util.List;
import java.util.Map; 
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
  	
  	@PostMapping("/delete")
	public ModelAndView delete(//
			@RequestParam("blogId") Long blogId,//
			ModelAndView mv) {
  		blogInfoRepository.deleteById(blogId);
		mv.setViewName("editor");		
		return mv;
	}
  	
  	@GetMapping("/update")
	public String getUpdateView() {
		return "update";
	}
  	
//  	@PostMapping("/update")
//	public ModelAndView update(//
//			@RequestParam("blogId") Long blogId,//
//			@RequestParam("username") String username,//
//   			@RequestParam("title") String title, //
//   			@RequestParam("content") String content, //
//			ModelAndView mv) {
//  		BlogInfo blogInfo = BlogInfo.builder()//
//  				.username(username)//
//  				.title(title)//
//				.content(content)//
//				.build();
//  		blogInfoRepository.save(blogInfo);
//		mv.setViewName("submit");
//		return mv;
//	}
//  	
//  	@PostMapping("/comment")
//	public ModelAndView comment(//
//			@RequestParam("blogId") Long blogId,//
//   			@RequestParam("comment") String comment, //
//			ModelAndView mv) {
//  		blogInfoRepository.findByBlogId(blogId).setComment(comment);		
//  		//System.out.print(blogInfo.getComment());
//  		//System.out.print(comment);
//  		//System.out.print(mv.addObject("comment", comment));
//		mv.setViewName("submit");
//		return mv;
//  	} 	
}
