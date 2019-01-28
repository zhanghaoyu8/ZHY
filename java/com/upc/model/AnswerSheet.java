package com.upc.model;

import java.util.Set;

public class AnswerSheet {
  private String illname;
  private Set<Integer> us;

  public Set<Integer> getUs() {
    return us;
  }
  public String getIllname() {
    return illname;
  }
  public void setIllname(String illname) {
    this.illname = illname;
  }
  public void setUs(Set<Integer> us) {
    this.us = us;
  }

  @Override
  public String toString() {
    return "选择的症状是: "+illname+"\n选项是:"+us;
  }
}
