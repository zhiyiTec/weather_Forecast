package com.boot.zhiyi.mapper;

import java.util.List;

import com.boot.zhiyi.model.Weather;

public interface GetWeatherByNameAndWeatherDate {
	public List<Weather> getWeatherByNameAndWeatherDate(Weather weather);
}
