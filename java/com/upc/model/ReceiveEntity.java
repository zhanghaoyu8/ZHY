package com.upc.model;

public class ReceiveEntity {
  //都是jsonString
  private String drugs;
  private String record;
  private String operations;
  public ReceiveEntity(){}
  public ReceiveEntity(String drugs, String record) {
    this.drugs = drugs;
    this.record = record;
  }
  
  public String getOperations() {
	    return operations;
	 }
  public void setOperations() {
	    this.operations = operations;
	 }
  
  public String getDrugs() {
    return drugs;
  }

  public void setDrugs(String drugs) {
    this.drugs = drugs;
  }

  public String getRecord() {
    return record;
  }

  public void setRecord(String record) {
    this.record = record;
  }
}
