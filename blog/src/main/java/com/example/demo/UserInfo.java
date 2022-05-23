package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // 自动增加生成
	private Long id;
	
	@Size(min = 3, max = 100)
	@Column(name = "username")
	private String username;

	@Size(min = 3, max = 100)
	@Column(name = "password")
	private String password;
	
	
	public UserInfo() {
	}
	
	public UserInfo(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + username + ", password=" + password + "]";
	}

}