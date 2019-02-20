package com.boot.zhiyi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.boot.zhiyi.service.SaveWeatherToDBService;
import com.boot.zhiyi.service.SaveCaptinCityToDBService;
@Controller
public class SaveCaptinController {
	@Autowired
	SaveCaptinCityToDBService SaveCaptinCityToDBService;
	@ResponseBody
	@RequestMapping("/saveCaptin")
	public Map<String, Object> saveCaptin(){
		Map<String, Object>map=new HashMap<String,Object>();
		SaveCaptinCityToDBService.savCaptinCity();
		map.put("result", "省会保存到数据中");
		return map;
	}
}
