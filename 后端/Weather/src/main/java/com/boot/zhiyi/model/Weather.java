package com.boot.zhiyi.model;

import java.util.Date;

public class Weather {
	private String  cityName;
	private Date date;
	private String weatherCondition;
	private String weatherDate;
	private String weatherTempture;
	private String weatherWin;
	private String weather;
	public Weather() {
		
	}
	
	public Weather(String cityName, Date date, String weatherCondition, String weatherDate, String weatherTempture,
			String weatherWin, String weather) {
		this.cityName = cityName;
		this.date = date;
		this.weatherCondition = weatherCondition;
		this.weatherDate = weatherDate;
		this.weatherTempture = weatherTempture;
		this.weatherWin = weatherWin;
		this.weather = weather;
	}

	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getWeatherCondition() {
		return weatherCondition;
	}
	public void setWeatherCondition(String weatherCondition) {
		this.weatherCondition = weatherCondition;
	}
	public String getWeatherDate() {
		return weatherDate;
	}
	public void setWeatherDate(String weatherDate) {
		this.weatherDate = weatherDate;
	}
	public String getWeatherTempture() {
		return weatherTempture;
	}
	public void setWeatherTempture(String weatherTempture) {
		this.weatherTempture = weatherTempture;
	}
	public String getWeatherWin() {
		return weatherWin;
	}
	public void setWeatherWin(String weatherWin) {
		this.weatherWin = weatherWin;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	
}
