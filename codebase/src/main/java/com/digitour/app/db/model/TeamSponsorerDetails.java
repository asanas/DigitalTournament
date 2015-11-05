package com.digitour.app.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sponsordetails")
public class TeamSponsorerDetails implements java.io.Serializable {

    private Long id;
    private String name;
    private String description;
    private String sponsorshipDetails;
    private String otherPerks;
    private String logoLink;
    
    public TeamSponsorerDetails() {

    }

    @Id
    @GeneratedValue
    @Column(name = "sponsorer_id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    @Column(name = "sponsor_name", nullable = false)
    public String getName() {
        return name;
    }

    @Column(name = "sponsor_description")
    public String getDescription() {
        return description;
    }

    @Column(name = "sponsorship_details")
    public String getSponsorshipDetails() {
        return sponsorshipDetails;
    }

    @Column(name = "other_perks")
    public String getOtherPerks() {
        return otherPerks;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSponsorshipDetails(String sponsorshipDetails) {
        this.sponsorshipDetails = sponsorshipDetails;
    }

    public void setOtherPerks(String otherPerks) {
        this.otherPerks = otherPerks;
    }
    
    @Column(name = "sponsor_logo_link", nullable = false)
    public String getLogoLink() {
        return logoLink;
    }

    public void setLogoLink(String logoLink) {
        this.logoLink = logoLink;
    }

}
