package com.digitour.app.model;

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

import com.digitour.app.db.model.TournamentOfficial;
import com.digitour.app.db.model.TournamentParticipant;

@Entity
@Table(name = "tournament_match_master")
public class TournamentMatchMaster implements java.io.Serializable {

	private Long tournamentMatchId;
	private TournamentOfficial officialMasterByFkMatchRefree;
	private TournamentOfficial officialMasterByFkUmpire2;
	private TournamentOfficial officialMasterByFkUmpire1;
	private TournamentOfficial officialMasterByFkScorer2;
	private TournamentOfficial officialMasterByFkScorer1;
	private TournamentParticipant tournamentParticipantMasterByFkTeam2Id;
	private TournamentParticipant tournamentParticipantMasterByFkTeam1Id;
	private TournamentScheduleMaster tournamentScheduleMaster;
	private long matchNumber;
	private String matchDetails;
	private Set<MatchPointMaster> matchPointMasters = new HashSet<MatchPointMaster>(0);
	private Set<TossDetailsMaster> tossDetailsMasters = new HashSet<TossDetailsMaster>(0);
	private Set<TournamentScheduleMaster> tournamentScheduleMasters = new HashSet<TournamentScheduleMaster>(0);
	private Set<TournamentMatchResultMaster> tournamentMatchResultMasters = new HashSet<TournamentMatchResultMaster>(0);
	private Set<TournamentMatchFoulMaster> tournamentMatchFoulMasters = new HashSet<TournamentMatchFoulMaster>(0);

	public TournamentMatchMaster() {
	}

	public TournamentMatchMaster(TournamentOfficial officialMasterByFkMatchRefree, TournamentOfficial officialMasterByFkUmpire2,
			TournamentOfficial officialMasterByFkUmpire1, TournamentOfficial officialMasterByFkScorer2,
			TournamentOfficial officialMasterByFkScorer1,
			TournamentParticipant tournamentParticipantMasterByFkTeam2Id,
			TournamentParticipant tournamentParticipantMasterByFkTeam1Id,
			TournamentScheduleMaster tournamentScheduleMaster, long matchNumber, String matchDetails) {
		this.officialMasterByFkMatchRefree = officialMasterByFkMatchRefree;
		this.officialMasterByFkUmpire2 = officialMasterByFkUmpire2;
		this.officialMasterByFkUmpire1 = officialMasterByFkUmpire1;
		this.officialMasterByFkScorer2 = officialMasterByFkScorer2;
		this.officialMasterByFkScorer1 = officialMasterByFkScorer1;
		this.tournamentParticipantMasterByFkTeam2Id = tournamentParticipantMasterByFkTeam2Id;
		this.tournamentParticipantMasterByFkTeam1Id = tournamentParticipantMasterByFkTeam1Id;
		this.tournamentScheduleMaster = tournamentScheduleMaster;
		this.matchNumber = matchNumber;
		this.matchDetails = matchDetails;
	}

	public TournamentMatchMaster(TournamentOfficial officialMasterByFkMatchRefree, TournamentOfficial officialMasterByFkUmpire2,
			TournamentOfficial officialMasterByFkUmpire1, TournamentOfficial officialMasterByFkScorer2,
			TournamentOfficial officialMasterByFkScorer1,
			TournamentParticipant tournamentParticipantMasterByFkTeam2Id,
			TournamentParticipant tournamentParticipantMasterByFkTeam1Id,
			TournamentScheduleMaster tournamentScheduleMaster, long matchNumber, String matchDetails,
			Set<MatchPointMaster> matchPointMasters, Set<TossDetailsMaster> tossDetailsMasters,
			Set<TournamentScheduleMaster> tournamentScheduleMasters,
			Set<TournamentMatchResultMaster> tournamentMatchResultMasters,
			Set<TournamentMatchFoulMaster> tournamentMatchFoulMasters) {
		this.officialMasterByFkMatchRefree = officialMasterByFkMatchRefree;
		this.officialMasterByFkUmpire2 = officialMasterByFkUmpire2;
		this.officialMasterByFkUmpire1 = officialMasterByFkUmpire1;
		this.officialMasterByFkScorer2 = officialMasterByFkScorer2;
		this.officialMasterByFkScorer1 = officialMasterByFkScorer1;
		this.tournamentParticipantMasterByFkTeam2Id = tournamentParticipantMasterByFkTeam2Id;
		this.tournamentParticipantMasterByFkTeam1Id = tournamentParticipantMasterByFkTeam1Id;
		this.tournamentScheduleMaster = tournamentScheduleMaster;
		this.matchNumber = matchNumber;
		this.matchDetails = matchDetails;
		this.matchPointMasters = matchPointMasters;
		this.tossDetailsMasters = tossDetailsMasters;
		this.tournamentScheduleMasters = tournamentScheduleMasters;
		this.tournamentMatchResultMasters = tournamentMatchResultMasters;
		this.tournamentMatchFoulMasters = tournamentMatchFoulMasters;
	}

	@Id
    @GeneratedValue
    @Column(name = "tournament_match_id", unique = true, nullable = false)
	public Long getTournamentMatchId() {
		return this.tournamentMatchId;
	}

	public void setTournamentMatchId(Long tournamentMatchId) {
		this.tournamentMatchId = tournamentMatchId;
	}

	@ManyToOne
	@JoinColumn(name = "official_profile_id")
	public TournamentOfficial getOfficialMasterByFkMatchRefree() {
		return this.officialMasterByFkMatchRefree;
	}

	public void setOfficialMasterByFkMatchRefree(TournamentOfficial officialMasterByFkMatchRefree) {
		this.officialMasterByFkMatchRefree = officialMasterByFkMatchRefree;
	}

	@ManyToOne
    @JoinColumn(name = "official_profile_id")
	public TournamentOfficial getOfficialMasterByFkUmpire2() {
		return this.officialMasterByFkUmpire2;
	}

	public void setOfficialMasterByFkUmpire2(TournamentOfficial officialMasterByFkUmpire2) {
		this.officialMasterByFkUmpire2 = officialMasterByFkUmpire2;
	}

	@ManyToOne
    @JoinColumn(name = "official_profile_id")
	public TournamentOfficial getOfficialMasterByFkUmpire1() {
		return this.officialMasterByFkUmpire1;
	}

	public void setOfficialMasterByFkUmpire1(TournamentOfficial officialMasterByFkUmpire1) {
		this.officialMasterByFkUmpire1 = officialMasterByFkUmpire1;
	}

	@ManyToOne
    @JoinColumn(name = "official_profile_id")
	public TournamentOfficial getOfficialMasterByFkScorer2() {
		return this.officialMasterByFkScorer2;
	}

	public void setOfficialMasterByFkScorer2(TournamentOfficial officialMasterByFkScorer2) {
		this.officialMasterByFkScorer2 = officialMasterByFkScorer2;
	}

	@ManyToOne
    @JoinColumn(name = "official_profile_id")
	public TournamentOfficial getOfficialMasterByFkScorer1() {
		return this.officialMasterByFkScorer1;
	}

	public void setOfficialMasterByFkScorer1(TournamentOfficial officialMasterByFkScorer1) {
		this.officialMasterByFkScorer1 = officialMasterByFkScorer1;
	}

	@ManyToOne
    @JoinColumn(name = "tour_participant_id")
	public TournamentParticipant getTournamentParticipantMasterByFkTeam2Id() {
		return this.tournamentParticipantMasterByFkTeam2Id;
	}

	public void setTournamentParticipantMasterByFkTeam2Id(
			TournamentParticipant tournamentParticipantMasterByFkTeam2Id) {
		this.tournamentParticipantMasterByFkTeam2Id = tournamentParticipantMasterByFkTeam2Id;
	}

	@ManyToOne
    @JoinColumn(name = "tour_participant_id")
	public TournamentParticipant getTournamentParticipantMasterByFkTeam1Id() {
		return this.tournamentParticipantMasterByFkTeam1Id;
	}

	public void setTournamentParticipantMasterByFkTeam1Id(
			TournamentParticipant tournamentParticipantMasterByFkTeam1Id) {
		this.tournamentParticipantMasterByFkTeam1Id = tournamentParticipantMasterByFkTeam1Id;
	}

	@ManyToOne
    @JoinColumn(name = "tournament_schedule_id")
	public TournamentScheduleMaster getTournamentScheduleMaster() {
		return this.tournamentScheduleMaster;
	}

	public void setTournamentScheduleMaster(TournamentScheduleMaster tournamentScheduleMaster) {
		this.tournamentScheduleMaster = tournamentScheduleMaster;
	}
	
	@Column(name = "match_number", nullable = false)
	public long getMatchNumber() {
		return this.matchNumber;
	}

	public void setMatchNumber(long matchNumber) {
		this.matchNumber = matchNumber;
	}

	@Column(name = "match_details", nullable = false)
	public String getMatchDetails() {
		return this.matchDetails;
	}

	public void setMatchDetails(String matchDetails) {
		this.matchDetails = matchDetails;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tournament_match_master")
    public Set<MatchPointMaster> getMatchPointMasters() {
		return this.matchPointMasters;
	}

	public void setMatchPointMasters(Set<MatchPointMaster> matchPointMasters) {
		this.matchPointMasters = matchPointMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tournament_match_master")
	public Set<TossDetailsMaster> getTossDetailsMasters() {
		return this.tossDetailsMasters;
	}

	public void setTossDetailsMasters(Set<TossDetailsMaster> tossDetailsMasters) {
		this.tossDetailsMasters = tossDetailsMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tournament_match_master")
	public Set<TournamentScheduleMaster> getTournamentScheduleMasters() {
		return this.tournamentScheduleMasters;
	}

	public void setTournamentScheduleMasters(Set<TournamentScheduleMaster> tournamentScheduleMasters) {
		this.tournamentScheduleMasters = tournamentScheduleMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tournament_match_master")
	public Set<TournamentMatchResultMaster> getTournamentMatchResultMasters() {
		return this.tournamentMatchResultMasters;
	}

	public void setTournamentMatchResultMasters(Set<TournamentMatchResultMaster> tournamentMatchResultMasters) {
		this.tournamentMatchResultMasters = tournamentMatchResultMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tournament_match_master")
	public Set<TournamentMatchFoulMaster> getTournamentMatchFoulMasters() {
		return this.tournamentMatchFoulMasters;
	}

	public void setTournamentMatchFoulMasters(Set<TournamentMatchFoulMaster> tournamentMatchFoulMasters) {
		this.tournamentMatchFoulMasters = tournamentMatchFoulMasters;
	}

}
