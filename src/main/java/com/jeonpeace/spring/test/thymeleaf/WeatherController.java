package com.jeonpeace.spring.test.thymeleaf;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeonpeace.spring.test.thymeleaf.domain.WeatherHistory;
import com.jeonpeace.spring.test.thymeleaf.service.WeatherService;

@Controller
@RequestMapping("/thymeleaf/weather")
public class WeatherController {

	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/list")
	public String list(Model model) {
		
		List<WeatherHistory> weatherList = weatherService.getAllWeather();
		
		model.addAttribute("weatherList", weatherList);
		
		return "thymeleaf/weather/list";
	}

	@GetMapping("/input")
	public String input() {
		
		return "thymeleaf/weather/input";
	}
	
	@PostMapping("/create")
	public String create(@RequestParam("date") @DateTimeFormat(pattern="yyyy년 MM월 dd일") LocalDate date
						, @RequestParam("weather") String weather
						, @RequestParam("temperatures") double temperatures
						, @RequestParam("precipitation") double precipitation
						, @RequestParam("microDust") String microDust
						, @RequestParam("windSpeed") double windSpeed) { 
		
		int count = weatherService.addWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
		
		return "redirect:/thymeleaf/weather/list";
	}
	
}
