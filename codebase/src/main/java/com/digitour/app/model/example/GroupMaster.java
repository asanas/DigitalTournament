package com.digitour.app.model.example;

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
@Table(name = "group_master")
public class GroupMaster implements java.io.Serializable {

	private Long groupId;
	private String groupName;
	private Set<TournamentGroupDetailsMaster> tournamentGroupDetailsMasters = new HashSet<TournamentGroupDetailsMaster>(
			0);

	public GroupMaster() {
	}

	public GroupMaster(String groupName) {
		this.groupName = groupName;
	}

	public GroupMaster(String groupName, Set<TournamentGroupDetailsMaster> tournamentGroupDetailsMasters) {
		this.groupName = groupName;
		this.tournamentGroupDetailsMasters = tournamentGroupDetailsMasters;
	}
	
	@Id
    @GeneratedValue
    @Column(name = "group_id", unique = true, nullable = false)
	public Long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	@Column(name = "group_name", unique = true, nullable = false)
	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "groupmaster")
	public Set<TournamentGroupDetailsMaster> getTournamentGroupDetailsMasters() {
		return this.tournamentGroupDetailsMasters;
	}

	public void setTournamentGroupDetailsMasters(Set<TournamentGroupDetailsMaster> tournamentGroupDetailsMasters) {
		this.tournamentGroupDetailsMasters = tournamentGroupDetailsMasters;
	}

}
