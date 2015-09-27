package com.digitour.app.model;
// Generated 19 Sep, 2015 10:42:06 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.digitour.app.db.model.PlayerProfile;
import com.digitour.app.db.model.TournamentParticipant;

@Entity
@Table(name = "tournament_participant_team_master")
public class TournamentParticipantTeamMaster implements java.io.Serializable {

	private Long tourPTId;
	private PlayerProfile playerProfileMaster;
	private TournamentParticipant tournamentParticipantMaster;
	private long playerChaseNumber;
	private Set<TournamentMatchResultMaster> tournamentMatchResultMasters = new HashSet<TournamentMatchResultMaster>(0);
	private Set<MatchPointMaster> matchPointMastersForFkDefenceId = new HashSet<MatchPointMaster>(0);
	private Set<MatchPointMaster> matchPointMastersForFkAttackerId = new HashSet<MatchPointMaster>(0);
	private Set<MatchPointMaster> matchPointMastersForFkAssistId = new HashSet<MatchPointMaster>(0);

	public TournamentParticipantTeamMaster() {
	}

	public TournamentParticipantTeamMaster(PlayerProfile playerProfileMaster,
			TournamentParticipant tournamentParticipantMaster, long playerChaseNumber) {
		this.playerProfileMaster = playerProfileMaster;
		this.tournamentParticipantMaster = tournamentParticipantMaster;
		this.playerChaseNumber = playerChaseNumber;
	}

	public TournamentParticipantTeamMaster(PlayerProfile playerProfileMaster,
			TournamentParticipant tournamentParticipantMaster, long playerChaseNumber,
			Set<TournamentMatchResultMaster> tournamentMatchResultMasters,
			Set<MatchPointMaster> matchPointMastersForFkDefenceId,
			Set<MatchPointMaster> matchPointMastersForFkAttackerId,
			Set<MatchPointMaster> matchPointMastersForFkAssistId) {
		this.playerProfileMaster = playerProfileMaster;
		this.tournamentParticipantMaster = tournamentParticipantMaster;
		this.playerChaseNumber = playerChaseNumber;
		this.tournamentMatchResultMasters = tournamentMatchResultMasters;
		this.matchPointMastersForFkDefenceId = matchPointMastersForFkDefenceId;
		this.matchPointMastersForFkAttackerId = matchPointMastersForFkAttackerId;
		this.matchPointMastersForFkAssistId = matchPointMastersForFkAssistId;
	}

	@Id
    @GeneratedValue
    @Column(name = "tour_p_t_id", unique = true, nullable = false)
	public Long getTourPTId() {
		return this.tourPTId;
	}

	public void setTourPTId(Long tourPTId) {
		this.tourPTId = tourPTId;
	}

	@ManyToOne
	@JoinColumn(name="player_profile_id", nullable=false)
	public PlayerProfile getPlayerProfileMaster() {
		return this.playerProfileMaster;
	}

	public void setPlayerProfileMaster(PlayerProfile playerProfileMaster) {
		this.playerProfileMaster = playerProfileMaster;
	}

	@ManyToOne
	@JoinColumn(name = "tour_participant_id")
	public TournamentParticipant getTournamentParticipantMaster() {
		return this.tournamentParticipantMaster;
	}

	public void setTournamentParticipantMaster(TournamentParticipant tournamentParticipantMaster) {
		this.tournamentParticipantMaster = tournamentParticipantMaster;
	}

	@Column(name = "last_name", nullable = false)
	public long getPlayerChaseNumber() {
		return this.playerChaseNumber;
	}

	public void setPlayerChaseNumber(long playerChaseNumber) {
		this.playerChaseNumber = playerChaseNumber;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tournament_participant_team_master")
	public Set<TournamentMatchResultMaster> getTournamentMatchResultMasters() {
		return this.tournamentMatchResultMasters;
	}

	public void setTournamentMatchResultMasters(Set<TournamentMatchResultMaster> tournamentMatchResultMasters) {
		this.tournamentMatchResultMasters = tournamentMatchResultMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tournament_participant_team_master")
	public Set<MatchPointMaster> getMatchPointMastersForFkDefenceId() {
		return this.matchPointMastersForFkDefenceId;
	}

	public void setMatchPointMastersForFkDefenceId(Set<MatchPointMaster> matchPointMastersForFkDefenceId) {
		this.matchPointMastersForFkDefenceId = matchPointMastersForFkDefenceId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tournament_participant_team_master")
	public Set<MatchPointMaster> getMatchPointMastersForFkAttackerId() {
		return this.matchPointMastersForFkAttackerId;
	}

	public void setMatchPointMastersForFkAttackerId(Set<MatchPointMaster> matchPointMastersForFkAttackerId) {
		this.matchPointMastersForFkAttackerId = matchPointMastersForFkAttackerId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tournament_participant_team_master")
	public Set<MatchPointMaster> getMatchPointMastersForFkAssistId() {
		return this.matchPointMastersForFkAssistId;
	}

	public void setMatchPointMastersForFkAssistId(Set<MatchPointMaster> matchPointMastersForFkAssistId) {
		this.matchPointMastersForFkAssistId = matchPointMastersForFkAssistId;
	}

}
