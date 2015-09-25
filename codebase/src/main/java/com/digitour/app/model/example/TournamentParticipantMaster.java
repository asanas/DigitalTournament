package com.digitour.app.model.example;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tournament_participant_master")
public class TournamentParticipantMaster implements java.io.Serializable {

	private Long tourParticipantId;
	private TeamMaster teamMaster;
	private TournamentMaster tournamentMaster;
	private Set<TournamentParticipantTeamMaster> tournamentParticipantTeamMasters = new HashSet<TournamentParticipantTeamMaster>(
			0);
	private Set<TournamentGroupDetailsMaster> tournamentGroupDetailsMasters = new HashSet<TournamentGroupDetailsMaster>(
			0);
	private Set<TournamentMatchMaster> tournamentMatchMastersForFkTeam2Id = new HashSet<TournamentMatchMaster>(0);
	private Set<TournamentMatchMaster> tournamentMatchMastersForFkTeam1Id = new HashSet<TournamentMatchMaster>(0);
	private Set<TossDetailsMaster> tossDetailsMasters = new HashSet<TossDetailsMaster>(0);
	private Set<TournamentParticipantPointsMaster> tournamentParticipantPointsMasters = new HashSet<TournamentParticipantPointsMaster>(
			0);
	private Set<TournamentMatchFoulMaster> tournamentMatchFoulMasters = new HashSet<TournamentMatchFoulMaster>(0);
	private Set<TournamentMatchResultMaster> tournamentMatchResultMasters = new HashSet<TournamentMatchResultMaster>(0);

	public TournamentParticipantMaster() {
	}

	public TournamentParticipantMaster(TeamMaster teamMaster, TournamentMaster tournamentMaster) {
		this.teamMaster = teamMaster;
		this.tournamentMaster = tournamentMaster;
	}

	public TournamentParticipantMaster(TeamMaster teamMaster, TournamentMaster tournamentMaster,
			Set<TournamentParticipantTeamMaster> tournamentParticipantTeamMasters,
			Set<TournamentGroupDetailsMaster> tournamentGroupDetailsMasters,
			Set<TournamentMatchMaster> tournamentMatchMastersForFkTeam2Id,
			Set<TournamentMatchMaster> tournamentMatchMastersForFkTeam1Id, Set<TossDetailsMaster> tossDetailsMasters,
			Set<TournamentParticipantPointsMaster> tournamentParticipantPointsMasters,
			Set<TournamentMatchFoulMaster> tournamentMatchFoulMasters,
			Set<TournamentMatchResultMaster> tournamentMatchResultMasters) {
		this.teamMaster = teamMaster;
		this.tournamentMaster = tournamentMaster;
		this.tournamentParticipantTeamMasters = tournamentParticipantTeamMasters;
		this.tournamentGroupDetailsMasters = tournamentGroupDetailsMasters;
		this.tournamentMatchMastersForFkTeam2Id = tournamentMatchMastersForFkTeam2Id;
		this.tournamentMatchMastersForFkTeam1Id = tournamentMatchMastersForFkTeam1Id;
		this.tossDetailsMasters = tossDetailsMasters;
		this.tournamentParticipantPointsMasters = tournamentParticipantPointsMasters;
		this.tournamentMatchFoulMasters = tournamentMatchFoulMasters;
		this.tournamentMatchResultMasters = tournamentMatchResultMasters;
	}

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "tour_participant_id", unique = true, nullable = false)
	public Long getTourParticipantId() {
		return this.tourParticipantId;
	}

	public void setTourParticipantId(Long tourParticipantId) {
		this.tourParticipantId = tourParticipantId;
	}

    @ManyToOne(optional=false)
    @JoinColumn(name="tourParticipantId", referencedColumnName="team_id")
	public TeamMaster getTeamMaster() {
		return this.teamMaster;
	}

	public void setTeamMaster(TeamMaster teamMaster) {
		this.teamMaster = teamMaster;
	}

    @ManyToOne(optional=false)
    @JoinColumn(name="tourParticipantId", referencedColumnName="tournament_id")
	public TournamentMaster getTournamentMaster() {
		return this.tournamentMaster;
	}

	public void setTournamentMaster(TournamentMaster tournamentMaster) {
		this.tournamentMaster = tournamentMaster;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tournamentparticipantmaster")
	public Set<TournamentParticipantTeamMaster> getTournamentParticipantTeamMasters() {
		return this.tournamentParticipantTeamMasters;
	}

	public void setTournamentParticipantTeamMasters(
			Set<TournamentParticipantTeamMaster> tournamentParticipantTeamMasters) {
		this.tournamentParticipantTeamMasters = tournamentParticipantTeamMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tournamentparticipantmaster")
	public Set<TournamentGroupDetailsMaster> getTournamentGroupDetailsMasters() {
		return this.tournamentGroupDetailsMasters;
	}

	public void setTournamentGroupDetailsMasters(Set<TournamentGroupDetailsMaster> tournamentGroupDetailsMasters) {
		this.tournamentGroupDetailsMasters = tournamentGroupDetailsMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tournamentparticipantmaster")
	public Set<TournamentMatchMaster> getTournamentMatchMastersForFkTeam2Id() {
		return this.tournamentMatchMastersForFkTeam2Id;
	}

	public void setTournamentMatchMastersForFkTeam2Id(Set<TournamentMatchMaster> tournamentMatchMastersForFkTeam2Id) {
		this.tournamentMatchMastersForFkTeam2Id = tournamentMatchMastersForFkTeam2Id;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tournamentparticipantmaster")
	public Set<TournamentMatchMaster> getTournamentMatchMastersForFkTeam1Id() {
		return this.tournamentMatchMastersForFkTeam1Id;
	}

	public void setTournamentMatchMastersForFkTeam1Id(Set<TournamentMatchMaster> tournamentMatchMastersForFkTeam1Id) {
		this.tournamentMatchMastersForFkTeam1Id = tournamentMatchMastersForFkTeam1Id;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tournamentparticipantmaster")
	public Set<TossDetailsMaster> getTossDetailsMasters() {
		return this.tossDetailsMasters;
	}

	public void setTossDetailsMasters(Set<TossDetailsMaster> tossDetailsMasters) {
		this.tossDetailsMasters = tossDetailsMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tournamentparticipantmaster")
	public Set<TournamentParticipantPointsMaster> getTournamentParticipantPointsMasters() {
		return this.tournamentParticipantPointsMasters;
	}

	public void setTournamentParticipantPointsMasters(
			Set<TournamentParticipantPointsMaster> tournamentParticipantPointsMasters) {
		this.tournamentParticipantPointsMasters = tournamentParticipantPointsMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tournamentparticipantmaster")
	public Set<TournamentMatchFoulMaster> getTournamentMatchFoulMasters() {
		return this.tournamentMatchFoulMasters;
	}

	public void setTournamentMatchFoulMasters(Set<TournamentMatchFoulMaster> tournamentMatchFoulMasters) {
		this.tournamentMatchFoulMasters = tournamentMatchFoulMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tournamentparticipantmaster")
	public Set<TournamentMatchResultMaster> getTournamentMatchResultMasters() {
		return this.tournamentMatchResultMasters;
	}

	public void setTournamentMatchResultMasters(Set<TournamentMatchResultMaster> tournamentMatchResultMasters) {
		this.tournamentMatchResultMasters = tournamentMatchResultMasters;
	}

}
