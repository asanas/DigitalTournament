package com.digitour.app.model;
// Generated 19 Sep, 2015 10:42:06 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * RoleMaster generated by hbm2java
 */
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

	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<PlayerProfileMaster> getPlayerProfileMasters() {
		return this.playerProfileMasters;
	}

	public void setPlayerProfileMasters(Set<PlayerProfileMaster> playerProfileMasters) {
		this.playerProfileMasters = playerProfileMasters;
	}

}