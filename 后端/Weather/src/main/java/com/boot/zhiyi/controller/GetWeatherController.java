package com.boot.zhiyi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.zhiyi.model.Weather;
import com.boot.zhiyi.service.SaveWeatherToDBService;
import com.boot.zhiyi.service.getWeatherByCityNameService;
@Controller
public class GetWeatherController {
	@Autowired
	getWeatherByCityNameService getWeatherByCityNameService;
	@ResponseBody
	@RequestMapping("/getWeather")
	public Map<String, Object> getWeather(@RequestParam("cityName") String name,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		Map<String, Object>map=new HashMap<String,Object>();
		List<Weather>weathers= getWeatherByCityNameService.getWeatherUseCityName(name);
		map.put("weathers",weathers);
		return map;
	}
}
