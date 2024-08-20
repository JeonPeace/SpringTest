package com.jeonpeace.spring.test.thymeleaf.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeonpeace.spring.test.thymeleaf.domain.WeatherHistory;
import com.jeonpeace.spring.test.thymeleaf.repository.WeatherRepository;

@Service
public class WeatherService {

	@Autowired
	private WeatherRepository weatherRepository;
	
	public List<WeatherHistory> getAllWeather(){
		
		List<WeatherHistory> weatherList = weatherRepository.selectAllWeather();
		
		return weatherList;
	}
	
	public int addWeather(LocalDate date
						, String weather
						, double temperatures
						, double precipitation
						, String mircroDust
						, double windSpeed) {
		
		int count = weatherRepository.insertWeather(date, weather, temperatures, precipitation, mircroDust, windSpeed);
		
		return count;
	}
	
}
