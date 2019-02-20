package com.boot.zhiyi.service;

import java.util.List;

import com.boot.zhiyi.model.Weather;

public interface getCaptinService {
	public Boolean judgeCaptinExit(String captinName);//用于判断数据库中是否已经存在这个数据，默认true，也就是说true代表已经存在数据
}
