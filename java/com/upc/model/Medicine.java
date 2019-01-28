package com.upc.model;

public class Medicine {
  private Integer medicineId;

  private String medicineName;

  private Float price;
  private String effect;
  private String composition;

  public void setComposition(String composition) {
    this.composition = composition;
  }

  public void setEffect(String effect) {
    this.effect = effect;
  }

  public String getEffect() {
    return effect;
  }

  public String getComposition() {
    return composition;
  }



  public Integer getMedicineId() {
    return medicineId;
  }

  public void setMedicineId(Integer medicineId) {
    this.medicineId = medicineId;
  }

  public String getMedicineName() {
    return medicineName;
  }

  public void setMedicineName(String medicineName) {
    this.medicineName = medicineName == null ? null : medicineName.trim();
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "药名: " + medicineName + " 参考价格: " + price +"\n组成:"+composition+" 主治: "+effect+ "\n..........\n";
  }
}