package com.digitour.app.model.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tournament_group_details_master")
public class TournamentGroupDetailsMaster implements java.io.Serializable {

	private Long tourGroupId;
	private GroupMaster groupMaster;
	private TournamentParticipantMaster tournamentParticipantMaster;
	private String groupType;

	public TournamentGroupDetailsMaster() {
	}

	public TournamentGroupDetailsMaster(GroupMaster groupMaster,
			TournamentParticipantMaster tournamentParticipantMaster, String groupType) {
		this.groupMaster = groupMaster;
		this.tournamentParticipantMaster = tournamentParticipantMaster;
		this.groupType = groupType;
	}

	@Id
    @GeneratedValue
    @Column(name = "tour_group_id", unique = true, nullable = false)
	public Long getTourGroupId() {
		return this.tourGroupId;
	}

	public void setTourGroupId(Long tourGroupId) {
		this.tourGroupId = tourGroupId;
	}

    @ManyToOne(optional=false)
    @JoinColumn(name="tourGroupId", referencedColumnName="group_id")
	public GroupMaster getGroupMaster() {
		return this.groupMaster;
	}

	public void setGroupMaster(GroupMaster groupMaster) {
		this.groupMaster = groupMaster;
	}
	
    @ManyToOne(optional=false)
    @JoinColumn(name="tourGroupId", referencedColumnName="tour_participant_id")
	public TournamentParticipantMaster getTournamentParticipantMaster() {
		return this.tournamentParticipantMaster;
	}

	public void setTournamentParticipantMaster(TournamentParticipantMaster tournamentParticipantMaster) {
		this.tournamentParticipantMaster = tournamentParticipantMaster;
	}
	
	@Column(name = "group_type", nullable = false)
	public String getGroupType() {
		return this.groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

}
