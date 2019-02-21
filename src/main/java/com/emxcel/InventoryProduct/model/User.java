package com.emxcel.InventoryProduct.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "tbl_user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private long user_id;
	
	@Column(name="user_name")
	private String user_name;
	
	@Column(name="user_password")
	private String user_password;
	
	@ManyToMany
	@JoinTable(name = "tbl_user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> likedrole_user;

	public User()
	{
		
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public List<Role> getLikedrole_user() {
		return likedrole_user;
	}

	public void setLikedrole_user(List<Role> likedrole_user) {
		this.likedrole_user = likedrole_user;
	}

//	@Override
//	public String toString() {
//		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_password=" + user_password + "]";
//	}

}
