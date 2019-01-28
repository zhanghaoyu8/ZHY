package com.upc.model;

public class Recipe {
    private Integer rid;

    private String iname;

    private String sname;

    private String symptom;
    private Integer matchs;

    public Integer getMatchs() {
        return matchs;
    }

    public void setMatchs(Integer matchs) {
        this.matchs = matchs;
    }
    


    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname == null ? null : iname.trim();
    }

    public String getSname() {
        return sname;
    }
    


    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom == null ? null : symptom.trim();
    }
}