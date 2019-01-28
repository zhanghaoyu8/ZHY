package com.upc.model;

public class Illness {
    private Integer illnessId;

    private String illnessName;
    
    private String describe;

    public Integer getIllnessId() {
        return illnessId;
    }

    public void setIllnessId(Integer illnessId) {
        this.illnessId = illnessId;
    }

    public String getIllnessName() {
        return illnessName;
    }
    
    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getDescribe() {
        return describe;
    }

    

    public void setIllnessName(String illnessName) {
        this.illnessName = illnessName == null ? null : illnessName.trim();
    }
}