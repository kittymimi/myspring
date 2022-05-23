package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.BlogInfo;
import com.example.demo.UserInfo;
import com.example.demo.BlogInfoRepository;

@Service
public class BlogService{
	@Autowired
    private BlogInfoRepository blogInfoRepository;
	
	public List<BlogInfo> findBlogsByUserId(Long userId) {
		return blogInfoRepository.findByUserId(userId);
	}
	public BlogInfo addBlog(String title, String content, UserInfo user) {
		return blogInfoRepository.save(new BlogInfo());		
	}
	
}
