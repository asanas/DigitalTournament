package com.digitour.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role_master")
public class RoleMaster implements java.io.Serializable {

	private Long roleId;
	private String roleName;
	private Set<PlayerProfileMaster> playerProfileMasters = new HashSet<PlayerProfileMaster>(0);

	public RoleMaster() {
	}

	public RoleMaster(String roleName) {
		this.roleName = roleName;
	}

	public RoleMaster(String roleName, Set<PlayerProfileMaster> playerProfileMasters) {
		this.roleName = roleName;
		this.playerProfileMasters = playerProfileMasters;
	}
	
	@Id
    @GeneratedValue
    @Column(name = "role_id", unique = true, nullable = false)
	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Column(name = "role_name", nullable = false)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role_master")
	public Set<PlayerProfileMaster> getPlayerProfileMasters() {
		return this.playerProfileMasters;
	}

	public void setPlayerProfileMasters(Set<PlayerProfileMaster> playerProfileMasters) {
		this.playerProfileMasters = playerProfileMasters;
	}

}
