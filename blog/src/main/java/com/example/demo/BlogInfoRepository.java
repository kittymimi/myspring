package com.example.demo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.BlogInfo;

public interface BlogInfoRepository extends JpaRepository<BlogInfo, Long>{
	
	BlogInfo findByUserId(Long userId);

}