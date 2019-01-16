package com.boot.zhiyi.service;

import com.boot.zhiyi.model.Weather;

public interface GetWeatherByNameAndWeatherDateService {
	public Boolean getWeatherByNameAndWeatherDateService(Weather Weather);//通过城市名以及日期判断该天气是否已经存在
}
