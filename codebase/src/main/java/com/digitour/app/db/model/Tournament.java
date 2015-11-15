package com.digitour.app.db.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.digitour.app.db.model.support.enums.AgeGroup;

@Entity
@Table(name = "tournament")
public class Tournament implements java.io.Serializable {

    private Long tournamentId;
    private String tournamentName;
    private String displayName;
    private String description;
    private String location;
    private double prize;
    private String otherDetails;
    private String tourType;
    private String tourStatus;
    private Date tournamentStartDate;
    private Date tournamentEndDate;
    private Date createdDate;
    private AgeGroup ageGroup;
    
    public Tournament() {
        this.tournamentId = 0L;
    }

    public Tournament(String tourName, String tourDescription, String tourLocation, Date tournamentStartDate,
            Date tournamentEndDate, String ageGroup, String prize) {
        this.tournamentName = tourName;
        this.description = tourDescription;
        this.tournamentStartDate = tournamentStartDate;
        this.tournamentEndDate = tournamentEndDate;
        this.location = tourLocation;
        this.ageGroup = AgeGroup.valueOf(ageGroup.toUpperCase());
        this.prize = Double.parseDouble(prize);
        this.createdDate = new Date();
        this.tourStatus = "INPROGRESS";
        this.tourType = "ALLINDIA";
    }

    @Id
    @GeneratedValue
    @Column(name = "tournament_id", unique = true, nullable = false)
    public Long getTournamentId() {
        return this.tournamentId;
    }

    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
    }

    @Column(name = "tournament_name", nullable = false)
    public String getTournamentName() {
        return this.tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "location", nullable = false)
    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name = "prize", nullable = false)
    public double getPrize() {
        return this.prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    @Column(name = "other_details", nullable = false)
    public String getOtherDetails() {
        return this.otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    @Column(name = "tour_type", nullable = false)
    public String getTourType() {
        return this.tourType;
    }

    public void setTourType(String tourType) {
        this.tourType = tourType;
    }

    @Column(name = "tour_status", nullable = false)
    public String getTourStatus() {
        return this.tourStatus;
    }

    public void setTourStatus(String tourStatus) {
        this.tourStatus = tourStatus;
    }

    @Column(name = "tournament_start_date", nullable = false)
    public Date getTournamentStartDate() {
        return this.tournamentStartDate;
    }

    public void setTournamentStartDate(Date tournamentStartDate) {
        this.tournamentStartDate = tournamentStartDate;
    }

    @Column(name = "tournament_end_date", nullable = false)
    public Date getTournamentEndDate() {
        return this.tournamentEndDate;
    }

    public void setTournamentEndDate(Date tournamentEndDate) {
        this.tournamentEndDate = tournamentEndDate;
    }

    @Column(name = "created_date", nullable = false)
    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "age_group", nullable = false)
    public AgeGroup getAgeGroup() {
        return this.ageGroup;
    }

    public void setAgeGroup(AgeGroup ageGroup) {
        this.ageGroup = ageGroup;
    }

    @Transient
    public String getFormattedStartDate() {
        String resultDate = "";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        if(null != this.tournamentStartDate) {
            resultDate = formatter.format(tournamentStartDate);
        }
        return resultDate;
    }

    @Transient
    public String getFormattedEndDate() {
        String resultDate = "";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        if(null != this.tournamentEndDate) {
            resultDate = formatter.format(tournamentEndDate);
        }
        return resultDate;
    }

    @Column(name = "display_name")
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
