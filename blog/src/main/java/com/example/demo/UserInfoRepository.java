package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long>{
	
	UserInfo findByName(String username);

}
