package com.upc.model;

import java.util.List;

public class Record {
  private String sname;
  private List<String> symptoms;
  private List<String> drugs;
  private List<String> operations;
  private String match;

  public Record() {
  }

  public String getSname() {
    return sname;
  }

  public void setSname(String sname) {
    this.sname = sname;
  }

  public List<String> getSymptoms() {
    return symptoms;
  }

  public void setSymptoms(List<String> symptoms) {
    this.symptoms = symptoms;
  }

  public List<String> getDrugs() {
    return drugs;
  }
  public List<String> getOperations(){
	  return operations;
  }

  public void setDrugs(List<String> drugs) {
    this.drugs = drugs;
  }

  public String getMatch() {
    return match;
  }

  public void setMatch(String match) {
    this.match = match;
  }

  @Override
  public String toString() {
    return "sname: "+sname+" drugs: "+drugs.toString()+" syps: "+symptoms.toString()+"match: "+match;
  }
}
