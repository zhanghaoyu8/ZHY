package com.upc.model;

import java.util.List;

/**
 * 为微信端转移的item
 */
public class SdItemWX {

  private String sickname ;
  private List<Item> items;

  public void setSickname(String sickname) {
    this.sickname = sickname;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  public String getSickname() {
    return sickname;
  }

  public List<Item> getItems() {
    return items;
  }
}
