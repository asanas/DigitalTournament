package com.digitour.app.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tournamentparticipant")
public class TournamentParticipant implements java.io.Serializable {

	private Long tourParticipantId;
	private Team team;
	private Tournament tournament;
	private Group group;
	
	public TournamentParticipant() {
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tournament_participant_id", unique = true, nullable = false)
	public Long getTourParticipantId() {
		return this.tourParticipantId;
	}

	public void setTourParticipantId(Long tourParticipantId) {
		this.tourParticipantId = tourParticipantId;
	}

	@ManyToOne
	@JoinColumn(name = "team_id")
	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@ManyToOne
    @JoinColumn(name = "tournament_id")
	public Tournament getTournament() {
		return this.tournament;
	}

	public void setTournament(Tournament tournamentMaster) {
		this.tournament = tournamentMaster;
	}

	@ManyToOne
    @JoinColumn(name = "group_id")
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

}
