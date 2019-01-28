package com.upc.model;

public class OutsideOperation {
  private Integer id;

  private String sicName;

  private String opeName;
  private String content1;
  private String content2;
  private String content3;

  public void setId(Integer id) {
    this.id = id;
  }

  public void setSicName(String sicName) {
	  this.sicName = sicName == null ? null : sicName.trim();
  }

  public Integer getId() {
    return id;
  }

  public String getSicName() {
    return sicName;
  }



  public String getOpeName() {
    return opeName;
  }

  public void setOpeName(String opeName) {
    this.opeName = opeName;
  }

  public String getContent1() {
    return content1;
  }

  public void setContent1(String content1) {
    this.content1 = content1;
  }

  public String getContent2() {
    return content2;
  }

  public void setContent2(String content2) {
    this.content2 = content2;
  }

  public String getContent3() {
	   return content3;
}
  public void setContent3(String content3) {
	    this.content3 = content3;
}
	  
  @Override
  public String toString() {
    return "疗法名: " + opeName + " \n " + content1 +"\n"+content2+"\n"+content3+ "\n..........\n";
  }
}