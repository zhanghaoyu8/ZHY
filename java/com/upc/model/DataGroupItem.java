package com.upc.model;

public class DataGroupItem {
  private String text;
  private String group;
  public DataGroupItem(){}

  /**
   * 病情项,病情
   * @param text
   * @param group
   */
  public DataGroupItem(String text, String group) {
    this.text = text;
    this.group = group;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getGroup() {
    return group;
  }

  public String getText() {
    return text;
  }
}
