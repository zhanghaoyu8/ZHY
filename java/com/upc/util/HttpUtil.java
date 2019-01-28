package com.upc.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class HttpUtil {
  private HttpUtil() {
  }

  public static String sendOkHttpRequest(String address) {
    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
      .url(address).build();
    try {
      Gson gson = new Gson();
      Response response = client.newCall(request).execute();
      String text = response.body().string();
      Type type = new TypeToken<ArrayList<String>>() {
      }.getType();
      ArrayList<String> names = gson.fromJson(text, type);

    } catch (IOException e) {
      e.printStackTrace();
    }
    return "others";
  }
}
