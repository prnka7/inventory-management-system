package com.emxcel.InventoryProduct.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_permission database table.
 * 
 */
@Entity
@Table(name="tbl_permission")
@NamedQuery(name="Permission.findAll", query="SELECT p FROM Permission p")
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="permission_id")
	private Long permissionId;

	@Column(name="permission_name")
	private String permissionName;

	//bi-directional many-to-many association to Role
	@ManyToMany(mappedBy="tblPermissions")
	private List<Role> tblRoles;

	public Permission() {
	}

	public Long getPermissionId() {
		return this.permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionName() {
		return this.permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public List<Role> getTblRoles() {
		return this.tblRoles;
	}

	public void setTblRoles(List<Role> tblRoles) {
		this.tblRoles = tblRoles;
	}

}