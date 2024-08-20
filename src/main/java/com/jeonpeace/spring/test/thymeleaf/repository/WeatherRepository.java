package com.jeonpeace.spring.test.thymeleaf.repository;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jeonpeace.spring.test.thymeleaf.domain.WeatherHistory;

@Mapper
public interface WeatherRepository {

	public List<WeatherHistory> selectAllWeather();
	
	public int insertWeather(@Param("date") LocalDate date
							, @Param("weather") String weather
							, @Param("temperatures") double temeperatures
							, @Param("precipitation") double precipitation
							, @Param("microDust") String microDust
							, @Param("windSpeed") double windSpeed);
	
}
