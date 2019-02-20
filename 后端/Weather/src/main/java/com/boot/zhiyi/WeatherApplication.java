package com.boot.zhiyi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.boot.zhiyi.mapper")
public class WeatherApplication {
	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);
	}
}

