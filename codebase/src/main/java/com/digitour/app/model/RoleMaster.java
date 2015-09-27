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

import com.digitour.app.db.model.PlayerProfile;

@Entity
@Table(name = "role_master")
public class RoleMaster implements java.io.Serializable {

	private Long roleId;
	private String roleName;
	private Set<PlayerProfile> playerProfileMasters = new HashSet<PlayerProfile>(0);

	public RoleMaster() {
	}

	public RoleMaster(String roleName) {
		this.roleName = roleName;
	}

	public RoleMaster(String roleName, Set<PlayerProfile> playerProfileMasters) {
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
	public Set<PlayerProfile> getPlayerProfileMasters() {
		return this.playerProfileMasters;
	}

	public void setPlayerProfileMasters(Set<PlayerProfile> playerProfileMasters) {
		this.playerProfileMasters = playerProfileMasters;
	}

}
