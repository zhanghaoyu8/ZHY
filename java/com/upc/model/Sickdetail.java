package com.upc.model;

public class Sickdetail {
  public Sickdetail() {
  }

  public Sickdetail(String illName, String sdName, String sdPerformance, Integer sdIndex) {
    this.illName = illName;
    this.sdName = sdName;
    this.sdPerformance = sdPerformance;
    this.sdIndex = sdIndex;
  }

  private Integer sdId;

  private String illName;

  private String sdName;

  private String sdPerformance;

  private Integer sdIndex;

  public Integer getSdId() {
    return sdId;
  }

  public void setSdId(Integer sdId) {
    this.sdId = sdId;
  }
  
  public String getIllName() {
    return illName;
  }

  public void setIllName(String illName) {
    this.illName = illName == null ? null : illName.trim();
  }

  public String getSdName() {
    return sdName;
  }

  public void setSdName(String sdName) {
    this.sdName = sdName == null ? null : sdName.trim();
  }

  public String getSdPerformance() {
    return sdPerformance;
  }

  public void setSdPerformance(String sdPerformance) {
    this.sdPerformance = sdPerformance == null ? null : sdPerformance.trim();
  }

  @Override
  public String toString() {
    return illName + " " + sdName + ":" + sdPerformance;
  }

  public Integer getSdIndex() {
    return sdIndex;
  }

  public void setSdIndex(Integer sdIndex) {
    this.sdIndex = sdIndex;
  }
}