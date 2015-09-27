package com.digitour.app.db.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "group")
public class Group implements java.io.Serializable {

    private Long groupId;
    private String groupName;
    private List<TournamentParticipant> tournamentParticipantList;
        
    public Group() {
    }

    public Group(String groupName) {
        this.groupName = groupName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @OneToMany(mappedBy = "group")
	public List<TournamentParticipant> getTournamentParticipantList() {
		return tournamentParticipantList;
	}

	public void setTournamentParticipantList(List<TournamentParticipant> tournamentParticipantList) {
		this.tournamentParticipantList = tournamentParticipantList;
	}
}
