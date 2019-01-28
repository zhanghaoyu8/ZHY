package com.upc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class FilesController {

  @RequestMapping(value = "/appindex")
  public String appindex() {
    return "appindex";
  }

  @RequestMapping(value = "/getapp", method = RequestMethod.GET)
  public void getapp(HttpServletResponse res) {
    String fileName = "htzx.apk";
    String fileprefix = "/home/psd/apks/";
    res.setHeader("content-type", "application/octet-stream");
    res.setContentType("application/octet-stream");
    res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
    byte[] buff = new byte[1024];
    BufferedInputStream bis = null;
    OutputStream os = null;
    try {
      os = res.getOutputStream();
      bis = new BufferedInputStream(new FileInputStream(new File(fileprefix + fileName)));
      int i = bis.read(buff);
      while (i != -1) {
        os.write(buff, 0, buff.length);
        os.flush();
        i = bis.read(buff);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (bis != null) {
        try {
          bis.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    System.out.println("success");
  }

}
