package com.jeonpeace.spring.test.pension.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeonpeace.spring.test.pension.domain.Booking;
import com.jeonpeace.spring.test.pension.repository.PensionRepository;

@Service
public class PensionService {

	@Autowired
	private PensionRepository pensionRepository;
	
	public List<Booking> getBookingList(){
		
		List<Booking> bookingList = pensionRepository.selectBookingList();
		
		return bookingList;
	}
	
	public int addBooking(String name
						, LocalDate date
						, int day
						, int headcount
						, String phoneNumber) {
		
		int count = pensionRepository.insertBooking(name, date, day, headcount, phoneNumber);
		
		return count;
	}	
	
	public int deleteBooking(int id) {
		
		int count = pensionRepository.deleteBooking(id);
		
		return count;
	}
	
	public Booking checkBooking(String name, String phoneNumber){
		
		Booking booking = pensionRepository.checkBooking(name, phoneNumber);
		
		return booking;
	}
	
}
