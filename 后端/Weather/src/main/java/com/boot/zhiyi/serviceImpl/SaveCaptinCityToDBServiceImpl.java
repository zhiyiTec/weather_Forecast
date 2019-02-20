package com.boot.zhiyi.serviceImpl;

import java.io.File;
import java.io.IOException;
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
import com.boot.zhiyi.model.Weathercity;
import com.boot.zhiyi.service.SaveWeatherToDBService;
import com.boot.zhiyi.mapper.SaveWeatherToDB;
import com.boot.zhiyi.service.getWeatherByCityNameService;
import com.boot.zhiyi.service.GetWeatherByNameAndWeatherDateService;
import com.boot.zhiyi.service.SaveCaptinCityToDBService;
import com.boot.zhiyi.mapper.SaveCaptinToDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.boot.zhiyi.service.getCaptinService;
@Service
public class SaveCaptinCityToDBServiceImpl implements SaveCaptinCityToDBService {
	//引入log4j
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	SaveCaptinToDB SaveCaptinToDB;
	@Autowired
	getCaptinService getCaptinService;
	@Override
	public void savCaptinCity() {
		// TODO Auto-generated method stub
		Document doc;
		List<Weathercity>lWeathercities=new LinkedList<Weathercity>();
		try {
			doc = Jsoup.parse(new File("C:\\Users\\17732\\Desktop\\tempt\\1.html"),"utf-8");
			Elements elements=doc.getElementsByTag("p");
			int i=0;
			for (Element e : elements) {
				String arr[]=null;
				System.out.println(e.text());
				i++;
				arr=e.text().split("=");
				String captinId=arr[0];
				String captinName=arr[1];
				Weathercity weathercity=new Weathercity();
				weathercity.setCaptinId(captinId);
				weathercity.setCaptinName(captinName);
				if(!getCaptinService.judgeCaptinExit(captinName)) {
					SaveCaptinToDB.saveCacptin(weathercity);
				}else {
					System.out.println("已经存在");
				}
				
			}
			System.out.println("总共"+i+"条信息");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//assuming register.html file in e drive  
		
	}
	

}
