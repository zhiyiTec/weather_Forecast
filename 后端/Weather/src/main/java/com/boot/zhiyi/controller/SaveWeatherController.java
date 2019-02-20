package com.boot.zhiyi.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.boot.zhiyi.service.SaveWeatherToDBService;
@Controller
public class SaveWeatherController {
	@Autowired
	SaveWeatherToDBService SaveWeatherToDBService;
	@ResponseBody
	@RequestMapping("/saveWeather")
	public Map<String, Object> saveWeather(HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object>map=new HashMap<String,Object>();
		SaveWeatherToDBService.saveWeather();
		map.put("result", true);
		return map;
	}
}
