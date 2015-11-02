package com.digitour.app.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;


@Entity
@Table(name = "matchpointdetails")
public class MatchPointDetails implements java.io.Serializable {

    private Long matchPointId;
    private Symbol symbol;
    private Long matchId;
    private Long defenceParticipantProfileId;
    private Long attackParticipantProfileId;
    private Long assistParticipantProfileId;
    private Long inningNumber;
    private Long turnNumber;
    private Long runTime;
    private Long perTime;
    private boolean out;
    private boolean turnClosure;
    private String defenderName;
    private String chaserName;
    private String assistName;
    
    public MatchPointDetails() {
    }

    @Id
    @GeneratedValue
    @Column(name = "match_point_id", unique = true, nullable = false)
    public Long getMatchPointId() {
        return this.matchPointId;
    }

    public void setMatchPointId(Long matchPointId) {
        this.matchPointId = matchPointId;
    }
    
    @ManyToOne
    @JoinColumn(name = "SYMBOL_ID")
    public Symbol getSymbol() {
        return this.symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    @Column(name = "inning_number", nullable = false)
    public Long getInningNumber() {
        return this.inningNumber;
    }

    public void setInningNumber(Long inningNumber) {
        this.inningNumber = inningNumber;
    }

    @Column(name = "turn_number", nullable = false)
    public Long getTurnNumber() {
        return this.turnNumber;
    }

    public void setTurnNumber(Long turnNumber) {
        this.turnNumber = turnNumber;
    }
    
    @Column(name = "run_time", nullable = false)
    public Long getRunTime() {
        return this.runTime;
    }

    public void setRunTime(Long runTime) {
        this.runTime = runTime;
    }

    @Column(name = "per_time", nullable = false)
    public Long getPerTime() {
        return this.perTime;
    }

    @Transient
    public String getFormattedPerTime() {
        String formattedPerTime = "<kbd ";
        String minutesStr = "";
        String cssClass = "dead";
        long minutes = this.perTime/60;
        long seconds = this.perTime%60;
        if(minutes > 0 ) {
            if(minutes <= 1) {
                cssClass = "good";
            } else if(minutes <= 2) {
                cssClass = "fair";
            } else {
                cssClass = "excellent";
            }
            minutesStr = minutes + "m";
        }
        return formattedPerTime += " class='"+ cssClass +"'>" + minutesStr + " " + seconds + "s</kbd>";
    }
    
    @Transient
    public String getFormattedRunTime() {
        String formattedRunTime = "";
        long minutes = this.runTime/60;
        long seconds = this.runTime%60;
        if(minutes > 0 ) {
            formattedRunTime += "<minute>" + minutes + "</minute>m ";
        }
        return formattedRunTime + "<second>" + seconds + "</second>s";
    }
    
    public void setPerTime(Long perTime) {
        this.perTime = perTime;
    }

    @Column(name = "tournament_match_id", nullable = false)
    public Long getMatchId() {
        return matchId;
    }

    @Column(name = "defender_id")
    public Long getDefenceParticipantProfileId() {
        return defenceParticipantProfileId;
    }

    @Column(name = "attacker_id")
    public Long getAttackParticipantProfileId() {
        return attackParticipantProfileId;
    }

    @Column(name = "assist_id")
    public Long getAssistParticipantProfileId() {
        return assistParticipantProfileId;
    }

    @Column(name="wicket_status", columnDefinition = "CHAR")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    public boolean isOut() {
        return out;
    }

    @Column(name="turn_closure", columnDefinition = "CHAR")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    public boolean isTurnClosure() {
        return turnClosure;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public void setDefenceParticipantProfileId(Long defenceParticipantProfileId) {
        this.defenceParticipantProfileId = defenceParticipantProfileId;
    }

    public void setAttackParticipantProfileId(Long attackParticipantProfileId) {
        this.attackParticipantProfileId = attackParticipantProfileId;
    }

    public void setAssistParticipantProfileId(Long assistParticipantProfileId) {
        this.assistParticipantProfileId = assistParticipantProfileId;
    }

    public void setOut(boolean out) {
        this.out = out;
    }

    public void setTurnClosure(boolean turnClosure) {
        this.turnClosure = turnClosure;
    }

    @Transient
    public String getDefenderName()
    {
        return defenderName;
    }

    @Transient
    public String getChaserName()
    {
        return chaserName;
    }

    @Transient
    public String getAssistName()
    {
        return assistName;
    }

    public void setDefenderName(String defenderName)
    {
        this.defenderName = defenderName;
    }

    public void setChaserName(String chaserName)
    {
        this.chaserName = chaserName;
    }

    public void setAssistName(String assistName)
    {
        this.assistName = assistName;
    }

}
