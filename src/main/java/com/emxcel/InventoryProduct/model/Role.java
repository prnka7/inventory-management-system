package com.emxcel.InventoryProduct.model;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "tbl_role")
public class Role {
	@Id
	private long role_id;

	private String role_name;

	public long getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	@ManyToMany(mappedBy = "likedrole_permission")
	List<Permission> likedpermission_role;
	@ManyToMany(mappedBy = "likedrole_user")
	List<User> likeduser_role;

	public List<Permission> getLikedpermission_role() {
		return likedpermission_role;
	}

	public void setLikedpermission_role(List<Permission> likedpermission_role) {
		this.likedpermission_role = likedpermission_role;
	}

	public List<User> getLikeduser_role() {
		return likeduser_role;
	}

	public void setLikeduser_role(List<User> likeduser_role) {
		this.likeduser_role = likeduser_role;
	}

	public void setRole_id(long role_id) {
		this.role_id = role_id;
	}

	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_name=" + role_name + "]";
	}

}
