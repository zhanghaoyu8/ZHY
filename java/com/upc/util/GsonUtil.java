package com.upc.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.upc.model.Medicine;
import com.upc.model.Record;
import com.upc.model.SickDetailItem;
import com.upc.model.OutsideOperation;
import com.upc.model.ViewObject;

import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonUtil {
  private GsonUtil() {
  }

  private static Gson gson = new Gson();

  public static String toJsonString(Object obj) {
    return gson.toJson(obj);
  }

  public static List<SickDetailItem> toSickDetailItems(String url) {
    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
      .url(url).build();
    try {
      Gson gson = new Gson();
      Response response = client.newCall(request).execute();
      String text = response.body().string();
      //想要的类型
      //Type type  = new TypeToken<ArrayList<SickDetailItem>>(){}.getType();
      Type type = new TypeToken<ViewObject>() {
      }.getType();
      ViewObject vo = gson.fromJson(text, type);
      ArrayList<SickDetailItem> items = (ArrayList<SickDetailItem>) vo.get("symptomsheet");
      //ArrayList<SickDetailItem> items = gson.fromJson(text,type);
      return items;
    } catch (IOException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    return null;
  }
  public static List<Medicine> toMedicines(String text){
    Type type = new TypeToken<List<Medicine>>() {
    }.getType();
    List<Medicine> medicines = gson.fromJson(text,type);

    return medicines;
  }
  public static List<OutsideOperation> toOutsideOperations(String text){
	 Type type = new TypeToken<List<OutsideOperation>>() {
	 }.getType();
	 List<OutsideOperation> outsideOperations = gson.fromJson(text,type);

	 return outsideOperations;
}
  public static List<Record> toRecordList(String text) {
    Type type = new TypeToken<List<Record>>() {
    }.getType();
    return gson.fromJson(text,type);
  }

}
