package com.emxcel.InventoryProduct.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tbl_role")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_id")
	private long role_id;

	@Column(name="role_name")
	private String role_name;

	@ManyToMany
	@JoinTable(
		name="tbl_permission_role"
		, joinColumns={
			@JoinColumn(name="role_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="permission_id")
			}
		)
	private List<Permission> tblPermissions;
	
	@ManyToMany(mappedBy="tblRoles")
	private List<User> tblUsers;
	
	public Role()
	{
		
	}
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

	public List<Permission> getTblPermissions() {
		return this.tblPermissions;
	}

	public void setTblPermissions(List<Permission> tblPermissions) {
		this.tblPermissions = tblPermissions;
	}

	public List<User> getTblUsers() {
		return this.tblUsers;
	}

	public void setTblUsers(List<User> tblUsers) {
		this.tblUsers = tblUsers;
	}

}
