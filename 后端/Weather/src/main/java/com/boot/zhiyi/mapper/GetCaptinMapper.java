package com.boot.zhiyi.mapper;

import java.util.List;

import com.boot.zhiyi.model.Weather;
import com.boot.zhiyi.model.Weathercity;

public interface GetCaptinMapper {
	public List<Weathercity> getCaptinCityByName(String name);//通过省会城市名获取省会城市id
}
