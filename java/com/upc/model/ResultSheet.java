package com.upc.model;

import java.util.List;

public class ResultSheet {
  private String sickname;
  private List<Medicine> medicines;
  private List<OutsideOperation> outsideOperations;

  public ResultSheet() {
  }

  public void setSickname(String sickname) {
    this.sickname = sickname;
  }
  public void setOutsideOperations(List<OutsideOperation> outsideOperations)
  {
	  this.outsideOperations = outsideOperations;
  }
  
  public void setMedicines(List<Medicine> medicines) {
    this.medicines = medicines;
  }

  public String getSickname() {
    return sickname;
  }

  public List<OutsideOperation> getOutsideOperations() {
	 return outsideOperations;
}
  
  public List<Medicine> getMedicines() {
    return medicines;
  }
}
