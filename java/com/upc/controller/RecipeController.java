package com.upc.controller;

import com.upc.util.GsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class RecipeController {
    @RequestMapping(path = {"/recipe"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String checkRecipes(@RequestParam("sname") String sname) {
        return GsonUtil.toJsonString("sd");
    }
}
