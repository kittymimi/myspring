package com.example.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.UserInfo;
import com.example.demo.UserInfoRepository;

@Service
public class UserService{
	@Autowired
    private UserInfoRepository userInfoRepository;
	
	public UserInfo findByUsername(String username) {
        return userInfoRepository.findByUsername(username);
    }
	
	public Optional<UserInfo> findById(Long id) {
        return userInfoRepository.findById(id);
    }
	
	public List<UserInfo> findAllUsers() {
		return userInfoRepository.findAll();
	}
	
	public UserInfo createUser(String username, String password) {
		if (findByUsername(username) != null) return null;
		return userInfoRepository.save(new UserInfo());		
	}
}