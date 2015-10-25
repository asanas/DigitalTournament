package com.digitour.app.client.pojo;

public class PlayerPerformace implements java.io.Serializable {
    String playerName;
    Long perTime;
    Long totalWickets;
    boolean out;
    
    public String getPlayerName() {
        return playerName;
    }
    public Long getPerTime() {
        return perTime;
    }
    public Long getTotalWickets() {
        return totalWickets;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public void setPerTime(Long perTime) {
        this.perTime = perTime;
    }
    public void setTotalWickets(Long totalWickets) {
        this.totalWickets = totalWickets;
    }
    public boolean isOut() {
        return out;
    }
    public void setOut(boolean out) {
        this.out = out;
    }
    
    public String getFormattedPerTime() {
        String formattedPerTime = "";
        long minutes = this.perTime/60;
        long seconds = this.perTime%60;
        if(minutes > 0 ) {
            formattedPerTime += "<minute>" + minutes + "</minute>m ";
        }
        return formattedPerTime + "<second>" + seconds + "</second>s";
    }
}