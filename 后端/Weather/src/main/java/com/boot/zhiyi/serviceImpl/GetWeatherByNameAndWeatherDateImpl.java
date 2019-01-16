package com.boot.zhiyi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.zhiyi.service.GetWeatherByNameAndWeatherDateService;

import com.boot.zhiyi.model.Weather;
import com.boot.zhiyi.mapper.GetWeatherByNameAndWeatherDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class GetWeatherByNameAndWeatherDateImpl implements GetWeatherByNameAndWeatherDateService {
	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	GetWeatherByNameAndWeatherDate GetWeatherByNameAndWeatherDate;

	@Override
	public Boolean getWeatherByNameAndWeatherDateService(Weather Weather) {
		// TODO Auto-generated method stub
		// 默认数据库中已经有数据
		Boolean re = true;
		List<Weather> weathers = GetWeatherByNameAndWeatherDate.getWeatherByNameAndWeatherDate(Weather);
		if (weathers.isEmpty()) {
			re = false;
			logger.info("这个城市以及这个时间的天气还未存储到数据库");
		} else {
			re = true;
			logger.info("这个城市以及这个时间的天气已经存储到数据库");
		}
		return re;
	}

}
