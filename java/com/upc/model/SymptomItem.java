package com.upc.model;

public class SymptomItem {
    private String performance;
    private Integer sdid;

    public SymptomItem(String performance, Integer sdid) {
        this.performance = performance;
        this.sdid = sdid;
    }
    public SymptomItem(){

    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public void setSdid(Integer sdid) {
        this.sdid = sdid;
    }

    public Integer getSdid() {
        return sdid;
    }

    public String getPerformance() {
        return performance;
    }

    @Override
    public String toString() {
        return sdid+":"+performance+"\n";
    }

}
