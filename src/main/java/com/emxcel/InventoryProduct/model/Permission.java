package com.emxcel.InventoryProduct.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="tbl_permission")
public class Permission {
	@Id
	private long permission_id;
	
	@Column(name="permission_name")
	private String permission_name;
	
	public long getPermission_id() {
		return permission_id;
	}
	public void setPermission_id(long permission_id) {
		this.permission_id = permission_id;
	}
	public String getPermission_name() {
		return permission_name;
	}
	public void setPermission_name(String permission_name) {
		this.permission_name = permission_name;
	}
	@ManyToMany
	@JoinTable(
			name="tbl_permission_role",
			joinColumns=@JoinColumn(name="permission_id"),
			inverseJoinColumns=@JoinColumn(name="role_id"))
	Set<Role> likedrole_permission=new HashSet<>();
	@Override
	public String toString() {
		return "Permission [permission_id=" + permission_id + ", permission_name=" + permission_name + "]";
	}

}
