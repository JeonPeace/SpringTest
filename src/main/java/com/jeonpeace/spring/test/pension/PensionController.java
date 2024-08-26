package com.jeonpeace.spring.test.pension;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeonpeace.spring.test.pension.domain.Booking;
import com.jeonpeace.spring.test.pension.service.PensionService;

@Controller
@RequestMapping("/pension")
public class PensionController {

	@Autowired
	private PensionService pensionService;
	
	@GetMapping("/main")
	public String main() {
		
		return "pension/main";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		
		List<Booking> bookingList = pensionService.getBookingList();
		
		model.addAttribute("bookingList", bookingList);
		
		return "pension/list";
	}
	
	@GetMapping("/input")
	public String inputBooking() {
		
		return "/pension/input";
	}
	
	@PostMapping("/create")
	@ResponseBody
	public Map<String, String> createBooking(@RequestParam("name") String name
								, @RequestParam("date") LocalDate date
								, @RequestParam("day") int day
								, @RequestParam("headcount") int headcount
								, @RequestParam("phoneNumber") String phoneNumber) {
		
		int count = pensionService.addBooking(name, date, day, headcount, phoneNumber);
		
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) {
			resultMap.put("result", "success");
		}else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public Map<String, String> deletBooking(@RequestParam("id") int id){
		
		int count = pensionService.deleteBooking(id);
		
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) {
			resultMap.put("result", "success");
		}else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@PostMapping("/check")
	@ResponseBody
	public Map<String, Object> checkBooking(@RequestParam("name") String name
											, @RequestParam("phoneNumber") String phoneNumber){
		
		Booking booking = pensionService.checkBooking(name, phoneNumber);
		
		Map<String, Object> resultMap = new HashMap<>();
		if(booking.getName() == name) {
			resultMap.put("result", "success");
			resultMap.put("name", name);
			resultMap.put("phoneNumber", phoneNumber);
			resultMap.put("day", booking.getDay());
			resultMap.put("date", booking.getDate());
			resultMap.put("headcount", booking.getHeadcount());
		}else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;		
	}
	
}
