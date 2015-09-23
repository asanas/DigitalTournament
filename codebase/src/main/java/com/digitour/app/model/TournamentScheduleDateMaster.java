package com.digitour.app.model;
// Generated 19 Sep, 2015 10:42:06 PM by Hibernate Tools 4.3.1

import java.util.Date;
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
@Table(name = "tournament_schedule_date_master")
public class TournamentScheduleDateMaster implements java.io.Serializable {

	private Long tournamentScheduleId;
	private TournamentMaster tournamentMaster;
	private Date tournamentDayDate;
	private String sessionTime;
	private int dayNumber;
	private Set<TournamentScheduleMaster> tournamentScheduleMasters = new HashSet<TournamentScheduleMaster>(0);

	public TournamentScheduleDateMaster() {
	}

	public TournamentScheduleDateMaster(TournamentMaster tournamentMaster, Date tournamentDayDate, String sessionTime,
			int dayNumber) {
		this.tournamentMaster = tournamentMaster;
		this.tournamentDayDate = tournamentDayDate;
		this.sessionTime = sessionTime;
		this.dayNumber = dayNumber;
	}

	public TournamentScheduleDateMaster(TournamentMaster tournamentMaster, Date tournamentDayDate, String sessionTime,
			int dayNumber, Set<TournamentScheduleMaster> tournamentScheduleMasters) {
		this.tournamentMaster = tournamentMaster;
		this.tournamentDayDate = tournamentDayDate;
		this.sessionTime = sessionTime;
		this.dayNumber = dayNumber;
		this.tournamentScheduleMasters = tournamentScheduleMasters;
	}

	@Id
    @GeneratedValue
    @Column(name = "tournament_schedule_id", unique = true, nullable = false)
	public Long getTournamentScheduleId() {
		return this.tournamentScheduleId;
	}

	public void setTournamentScheduleId(Long tournamentScheduleId) {
		this.tournamentScheduleId = tournamentScheduleId;
	}

    @ManyToOne
    @JoinColumn(name = "tournament_id")
	public TournamentMaster getTournamentMaster() {
		return this.tournamentMaster;
	}

	public void setTournamentMaster(TournamentMaster tournamentMaster) {
		this.tournamentMaster = tournamentMaster;
	}

	@Column(name = "tournament_day_date", nullable = false)
	public Date getTournamentDayDate() {
		return this.tournamentDayDate;
	}

	public void setTournamentDayDate(Date tournamentDayDate) {
		this.tournamentDayDate = tournamentDayDate;
	}

	@Column(name = "session_time", nullable = false)
	public String getSessionTime() {
		return this.sessionTime;
	}

	public void setSessionTime(String sessionTime) {
		this.sessionTime = sessionTime;
	}

	@Column(name = "day_number", nullable = false)
	public int getDayNumber() {
		return this.dayNumber;
	}

	public void setDayNumber(int dayNumber) {
		this.dayNumber = dayNumber;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tournament_schedule_date_master")
	public Set<TournamentScheduleMaster> getTournamentScheduleMasters() {
		return this.tournamentScheduleMasters;
	}

	public void setTournamentScheduleMasters(Set<TournamentScheduleMaster> tournamentScheduleMasters) {
		this.tournamentScheduleMasters = tournamentScheduleMasters;
	}

}
