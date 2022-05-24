package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.BlogInfo;

public interface BlogInfoRepository extends JpaRepository<BlogInfo, Long>{
	BlogInfo findByBlogId(Long blogId);
}