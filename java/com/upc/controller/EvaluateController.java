package com.upc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EvaluateController {
	/**
	 * 处理返回的值
	 * @return
	 */
	@RequestMapping(value="/rating",method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String solveRating(@RequestParam("credit") float credit,@RequestParam("medicineId") int medicineId) {
		return "";
	}
	
	
}
