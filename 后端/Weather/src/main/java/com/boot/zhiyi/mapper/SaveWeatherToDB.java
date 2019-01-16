package com.boot.zhiyi.mapper;

import com.boot.zhiyi.model.Weather;

public interface SaveWeatherToDB {
	public void saveWeather(Weather weather);//使用insert将数据插入到数据库
	public void updateWeather(Weather weather);//使用update更新数据库
}
