package com.digitour.app.model.example;

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

@Entity
@Table(name = "tournament_match_master")
public class TournamentMatchMaster implements java.io.Serializable {

	private Long tournamentMatchId;
	private OfficialMaster officialMasterByFkMatchRefree;
	private OfficialMaster officialMasterByFkUmpire2;
	private OfficialMaster officialMasterByFkUmpire1;
	private OfficialMaster officialMasterByFkScorer2;
	private OfficialMaster officialMasterByFkScorer1;
	private TournamentParticipantMaster tournamentParticipantMasterByFkTeam2Id;
	private TournamentParticipantMaster tournamentParticipantMasterByFkTeam1Id;
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

	public TournamentMatchMaster(OfficialMaster officialMasterByFkMatchRefree, OfficialMaster officialMasterByFkUmpire2,
			OfficialMaster officialMasterByFkUmpire1, OfficialMaster officialMasterByFkScorer2,
			OfficialMaster officialMasterByFkScorer1,
			TournamentParticipantMaster tournamentParticipantMasterByFkTeam2Id,
			TournamentParticipantMaster tournamentParticipantMasterByFkTeam1Id,
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

	public TournamentMatchMaster(OfficialMaster officialMasterByFkMatchRefree, OfficialMaster officialMasterByFkUmpire2,
			OfficialMaster officialMasterByFkUmpire1, OfficialMaster officialMasterByFkScorer2,
			OfficialMaster officialMasterByFkScorer1,
			TournamentParticipantMaster tournamentParticipantMasterByFkTeam2Id,
			TournamentParticipantMaster tournamentParticipantMasterByFkTeam1Id,
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

    @ManyToOne(optional=false)
    @JoinColumn(name="tournamentMatchId", referencedColumnName="official_profile_id")
	public OfficialMaster getOfficialMasterByFkMatchRefree() {
		return this.officialMasterByFkMatchRefree;
	}

	public void setOfficialMasterByFkMatchRefree(OfficialMaster officialMasterByFkMatchRefree) {
		this.officialMasterByFkMatchRefree = officialMasterByFkMatchRefree;
	}

    @ManyToOne(optional=false)
    @JoinColumn(name="tournamentMatchId", referencedColumnName="official_profile_id")
	public OfficialMaster getOfficialMasterByFkUmpire2() {
		return this.officialMasterByFkUmpire2;
	}

	public void setOfficialMasterByFkUmpire2(OfficialMaster officialMasterByFkUmpire2) {
		this.officialMasterByFkUmpire2 = officialMasterByFkUmpire2;
	}

    @ManyToOne(optional=false)
    @JoinColumn(name="tournamentMatchId", referencedColumnName="official_profile_id")
	public OfficialMaster getOfficialMasterByFkUmpire1() {
		return this.officialMasterByFkUmpire1;
	}

	public void setOfficialMasterByFkUmpire1(OfficialMaster officialMasterByFkUmpire1) {
		this.officialMasterByFkUmpire1 = officialMasterByFkUmpire1;
	}

    @ManyToOne(optional=false)
    @JoinColumn(name="tournamentMatchId", referencedColumnName="official_profile_id")
	public OfficialMaster getOfficialMasterByFkScorer2() {
		return this.officialMasterByFkScorer2;
	}

	public void setOfficialMasterByFkScorer2(OfficialMaster officialMasterByFkScorer2) {
		this.officialMasterByFkScorer2 = officialMasterByFkScorer2;
	}

    @ManyToOne(optional=false)
    @JoinColumn(name="tournamentMatchId", referencedColumnName="official_profile_id")
	public OfficialMaster getOfficialMasterByFkScorer1() {
		return this.officialMasterByFkScorer1;
	}

	public void setOfficialMasterByFkScorer1(OfficialMaster officialMasterByFkScorer1) {
		this.officialMasterByFkScorer1 = officialMasterByFkScorer1;
	}

    @ManyToOne(optional=false)
    @JoinColumn(name="tournamentMatchId", referencedColumnName="tour_participant_id")
	public TournamentParticipantMaster getTournamentParticipantMasterByFkTeam2Id() {
		return this.tournamentParticipantMasterByFkTeam2Id;
	}

	public void setTournamentParticipantMasterByFkTeam2Id(
			TournamentParticipantMaster tournamentParticipantMasterByFkTeam2Id) {
		this.tournamentParticipantMasterByFkTeam2Id = tournamentParticipantMasterByFkTeam2Id;
	}

    @ManyToOne(optional=false)
    @JoinColumn(name="tournamentMatchId", referencedColumnName="tour_participant_id")
	public TournamentParticipantMaster getTournamentParticipantMasterByFkTeam1Id() {
		return this.tournamentParticipantMasterByFkTeam1Id;
	}

	public void setTournamentParticipantMasterByFkTeam1Id(
			TournamentParticipantMaster tournamentParticipantMasterByFkTeam1Id) {
		this.tournamentParticipantMasterByFkTeam1Id = tournamentParticipantMasterByFkTeam1Id;
	}

    @ManyToOne(optional=false)
    @JoinColumn(name="tournamentMatchId", referencedColumnName="tournament_schedule_id")
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tournamentmatchmaster")
    public Set<MatchPointMaster> getMatchPointMasters() {
		return this.matchPointMasters;
	}

	public void setMatchPointMasters(Set<MatchPointMaster> matchPointMasters) {
		this.matchPointMasters = matchPointMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tournamentmatchmaster")
	public Set<TossDetailsMaster> getTossDetailsMasters() {
		return this.tossDetailsMasters;
	}

	public void setTossDetailsMasters(Set<TossDetailsMaster> tossDetailsMasters) {
		this.tossDetailsMasters = tossDetailsMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tournamentmatchmaster")
	public Set<TournamentScheduleMaster> getTournamentScheduleMasters() {
		return this.tournamentScheduleMasters;
	}

	public void setTournamentScheduleMasters(Set<TournamentScheduleMaster> tournamentScheduleMasters) {
		this.tournamentScheduleMasters = tournamentScheduleMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tournamentmatchmaster")
	public Set<TournamentMatchResultMaster> getTournamentMatchResultMasters() {
		return this.tournamentMatchResultMasters;
	}

	public void setTournamentMatchResultMasters(Set<TournamentMatchResultMaster> tournamentMatchResultMasters) {
		this.tournamentMatchResultMasters = tournamentMatchResultMasters;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tournamentmatchmaster")
	public Set<TournamentMatchFoulMaster> getTournamentMatchFoulMasters() {
		return this.tournamentMatchFoulMasters;
	}

	public void setTournamentMatchFoulMasters(Set<TournamentMatchFoulMaster> tournamentMatchFoulMasters) {
		this.tournamentMatchFoulMasters = tournamentMatchFoulMasters;
	}

}
