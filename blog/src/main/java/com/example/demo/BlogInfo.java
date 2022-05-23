package com.example.demo;

import java.sql.Date;
import javax.persistence.*;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Type;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

@Entity
@Table(name = "blogs")

public class BlogInfo {
	
	public BlogInfo(@Size(min = 1, max = 255) String title, String content, byte[] image, User user) {
		super();
		this.title = title;
		this.content = content;
		this.image = image;
		this.user = user;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public BlogInfo(@Size(min = 1, max = 255) String title, String content, User user) {
		this(title, content, null, user);
	}

	public BlogInfo() {}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // 自动增加生成
	private Long id;
	
	@Size(min = 1, max = 255)
	@Column(name = "title")
	private String title;

	@Column(name = "content")
	private String content;
	
	@Column(name = "created_at", insertable = false, updatable = false)
	private Date createdAt;
	
	@Lob
	@Column(name="image")
	@Type(type="org.hibernate.type.BinaryType")
	private byte[] image;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
}

