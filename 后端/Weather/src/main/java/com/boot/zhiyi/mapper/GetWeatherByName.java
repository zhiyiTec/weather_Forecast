package com.boot.zhiyi.mapper;

import java.util.List;

import com.boot.zhiyi.model.Weather;

public interface GetWeatherByName {
	public List<Weather> getWeatherByCityName(String cityName);
}
