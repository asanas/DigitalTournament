package com.digitour.app.db.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CITY")
public class City implements java.io.Serializable {

    private Long cityId;

    private State state;

    private String cityName;

    private List<PlayerProfile> playerList;
    
    private List<Team> teamList;
    
    private List<TournamentOfficial> tournamentOfficialList;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CITY_ID", unique = true, nullable = false)
    public Long getCityId() {
        return this.cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    @ManyToOne
    @JoinColumn(name="STATE_ID", nullable=false)
    public State getState() {
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Column(name = "city_name", nullable = false)
    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @OneToMany(mappedBy = "city")
	public List<PlayerProfile> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(List<PlayerProfile> playerList) {
		this.playerList = playerList;
	}

	@OneToMany(mappedBy = "city")
	public List<Team> getTeamList() {
		return teamList;
	}

	public void setTeamList(List<Team> teamList) {
		this.teamList = teamList;
	}

	@OneToMany(mappedBy = "city")
	public List<TournamentOfficial> getTournamentOfficialList() {
		return tournamentOfficialList;
	}

	public void setTournamentOfficialList(List<TournamentOfficial> tournamentOfficialList) {
		this.tournamentOfficialList = tournamentOfficialList;
	}
}
