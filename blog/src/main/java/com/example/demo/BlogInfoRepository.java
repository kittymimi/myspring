package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.BlogInfo;

public interface BlogInfoRepository  extends JpaRepository<BlogInfo, String>{
	BlogInfo findByID(String id);
}
