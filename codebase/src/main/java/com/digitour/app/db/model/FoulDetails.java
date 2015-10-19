package com.digitour.app.db.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "fouldetails")
public class FoulDetails implements java.io.Serializable {

    private Long foulId;
    private String foulName;
    private String foulDescription;
    private List<MatchFoulDetails> matchFoulList;
    private Long foulCount;
    
    public FoulDetails() {
    }

    public FoulDetails(String foulName, String foulDescription) {
        this.foulName = foulName;
        this.foulDescription = foulDescription;
    }

    @Id
    @GeneratedValue
    @Column(name = "foul_id", unique = true, nullable = false)
    public Long getFoulId() {
        return this.foulId;
    }

    public void setFoulId(Long foulId) {
        this.foulId = foulId;
    }

    @Column(name = "foul_name", nullable = false)
    public String getFoulName() {
        return this.foulName;
    }

    public void setFoulName(String foulName) {
        this.foulName = foulName;
    }

    @Column(name = "foul_description", nullable = false)
    public String getFoulDescription() {
        return this.foulDescription;
    }

    public void setFoulDescription(String foulDescription) {
        this.foulDescription = foulDescription;
    }

    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "foulDetails", cascade = CascadeType.ALL)
	public List<MatchFoulDetails> getMatchFoulList() {
		return matchFoulList;
	}

	public void setMatchFoulList(List<MatchFoulDetails> matchFoulList) {
		this.matchFoulList = matchFoulList;
	}

	@Transient
	public Long getFoulCount() {
		return foulCount;
	}

	public void setFoulCount(Long foulCount) {
		this.foulCount = foulCount;
	}

}
