package com.boot.zhiyi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.zhiyi.service.getCaptinService;
import com.boot.zhiyi.service.getWeatherByCityNameService;
import com.boot.zhiyi.mapper.GetWeatherByName;
import com.boot.zhiyi.model.Weather;
import com.boot.zhiyi.model.Weathercity;
import com.boot.zhiyi.mapper.GetCaptinMapper;
@Service
public class getCaptinServiceImpl implements getCaptinService {
	@Autowired
	GetCaptinMapper GetCaptinMapper;

	@Override
	public Boolean judgeCaptinExit(String captinName) {
		// TODO Auto-generated method stub
		List<Weathercity>weathercities=GetCaptinMapper.getCaptinCityByName(captinName);
		Boolean re=true;//存在就是true,不存在就是false
		if(!weathercities.isEmpty()) {
			re=true;
		}else {
			re=false;
		}
		return re;
	}

	

}
