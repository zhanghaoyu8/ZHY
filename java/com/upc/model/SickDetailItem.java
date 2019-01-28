package com.upc.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SickDetailItem {
    private String sickname ;
    private List<String>sdPerformance = new ArrayList<>();
    private List<Integer> sdId = new ArrayList<>();

    public void setSickname(String sickname) {
        this.sickname = sickname;
    }

    public String getSickname() {
        return sickname;
    }
    
    
    public List<String> getSdPerformance() {
        return sdPerformance;
    }

    public void setSdPerformance(List<String> sdPerformance) {
        this.sdPerformance = sdPerformance;
    }

    public List<Integer> getSdId() {
        return sdId;
    }

    public void setSdId(List<Integer> sdId) {
        this.sdId = sdId;
    }

    @Override
    public String toString() {
        return sickname+" "+sdId+","+sdPerformance+"\n";
    }
}
