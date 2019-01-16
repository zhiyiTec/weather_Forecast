package com.boot.zhiyi.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.zhiyi.model.Weather;
import com.boot.zhiyi.service.SaveWeatherToDBService;
import com.boot.zhiyi.mapper.SaveWeatherToDB;
import com.boot.zhiyi.service.getWeatherByCityNameService;
import com.boot.zhiyi.service.GetWeatherByNameAndWeatherDateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class SaveWeatherToDBServiceImpl implements SaveWeatherToDBService {
	//引入log4j
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	SaveWeatherToDB SaveWeatherToDB;
	
	@Autowired
	GetWeatherByNameAndWeatherDateService GetWeatherByNameAndWeatherDateService;
	@Override
	public void saveWeather() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date dt = new Date();
		 String date_N=sdf.format(dt);
		String city="101190101";
		String url = "http://www.weather.com.cn/weather/" +city  + ".shtml";
		List<String>lweather=new LinkedList<String>();//用于存储天气状况
		List<String>lweatherData=new LinkedList<String>();//用于存储日期
		List<String>lweatherTempture=new LinkedList<String>();//用于存储温度
		List<String>lweatherWin=new LinkedList<String>();//用于存储风向
		List<String>lweather_ALl=new LinkedList<String>();
		try {
			Document doc = Jsoup.connect(url).get();
			Elements content = doc.getElementsByClass("t clearfix");
			for (Element e : content) {
				Document conDoc = Jsoup.parse(e.toString());
				Elements cru = conDoc.getElementsByClass("crumbs fl");
				Elements sky = content.select("li[class^=sky skyid lv]");
				
				for (Element e1 : sky) {
					Elements weatherData=e1.select("h1");//此处用于获取日期天气
					String wDString=weatherData.text();
					Integer loca=wDString.indexOf("日")+1;//获取【日】所在的位置
					String wD=wDString.substring(0,loca);
					lweatherData.add(wD);
					Elements weather=e1.select("p[class=wea]");//用于获取天气信息
					lweather.add(weather.text());
					Elements weatherTempture= e1.select("p[class=tem]");//用于获取天气温度
					
					lweatherTempture.add(weatherTempture.text());
					Elements weatherWin=e1.select("span");//用于获取风向
					lweatherWin.add(weatherWin.attr("title"));
					
				}
				logger.info("获取天气成功");
				//System.out.println(sky.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("获取天气失败，请检查天气url");
		}

		logger.info("查询【南京】天气查询完毕");
	System.out.println("天气查询完毕！！");
	System.out.println("当前城市【"+"南京"+"】");
	for(int i=0;i<lweather.size();i++) {
		String wea_All="日期:"+lweatherData.get(i)+",天气状况:"+lweather.get(i)+",温度："+lweatherTempture.get(i)+",风向："+lweatherWin.get(i);
		lweather_ALl.add(wea_All);
		//System.out.println("日期:"+lweatherData.get(i)+",天气状况:"+lweather.get(i)+",温度："+lweatherTempture.get(i)+",风向："+lweatherWin.get(i));
	}
	for(int i=0;i<lweather.size();i++) {
		Weather weather=new Weather();
		weather.setCityName("南京");
		weather.setDate(dt);
		weather.setWeatherCondition(lweather.get(i));
		weather.setWeatherDate(lweatherData.get(i));
		weather.setWeatherTempture(lweatherTempture.get(i));
		weather.setWeatherWin(lweatherWin.get(i));
		weather.setWeather(lweather_ALl.get(i));
		if(!GetWeatherByNameAndWeatherDateService.getWeatherByNameAndWeatherDateService(weather)) {
			SaveWeatherToDB.saveWeather(weather);
			logger.info("未获取这个天气，已经存储到数据库");
		}else {
			SaveWeatherToDB.updateWeather(weather);
			logger.info("已经获取过这个天气，已经重新更新到数据库");
		}
		
	}
		
	}

}
