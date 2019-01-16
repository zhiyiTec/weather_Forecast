package com.boot.zhiyi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.zhiyi.service.getWeatherByCityNameService;
import com.boot.zhiyi.mapper.GetWeatherByName;
import com.boot.zhiyi.model.Weather;

@Service
public class getWeatherByCityNameServiceImpl implements getWeatherByCityNameService {
	@Autowired
	GetWeatherByName GetWeatherByName;

	@Override
	public Boolean getWeatherByCityName(String name) {
		// TODO Auto-generated method stub
		Boolean re = false;
		List<Weather> lWeathers = GetWeatherByName.getWeatherByCityName(name);
		if (!lWeathers.isEmpty()) {
			re = true;
		} else {
			re = false;
		}
		return re;
	}

	@Override
	public List<Weather> getWeatherUseCityName(String name) {
		// TODO Auto-generated method stub
		return GetWeatherByName.getWeatherByCityName(name);
	}

}
