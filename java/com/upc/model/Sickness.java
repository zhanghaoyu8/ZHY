package com.upc.model;

public class Sickness {
    private Integer sicknessId;

    private String sickName;

    public Integer getSicknessId() {
        return sicknessId;
    }

    public void setSicknessId(Integer sicknessId) {
        this.sicknessId = sicknessId;
    }

    public String getSickName() {
        return sickName;
    }

    public void setSickName(String sickName) {
        this.sickName = sickName == null ? null : sickName.trim();
    }
}