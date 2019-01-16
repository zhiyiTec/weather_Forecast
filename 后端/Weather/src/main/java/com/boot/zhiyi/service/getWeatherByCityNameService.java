package com.boot.zhiyi.service;

import java.util.List;

import com.boot.zhiyi.model.Weather;

public interface getWeatherByCityNameService {
	public Boolean getWeatherByCityName(String name);//通过城市名判断该天气是否已经存在
	public List<Weather> getWeatherUseCityName(String name);//通过城市名来获取天气信息
}
