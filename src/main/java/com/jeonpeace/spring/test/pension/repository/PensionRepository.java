package com.jeonpeace.spring.test.pension.repository;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jeonpeace.spring.test.pension.domain.Booking;

@Mapper
public interface PensionRepository {

	public List<Booking> selectBookingList();
	
	public int insertBooking(@Param("name") String name
							, @Param("date") LocalDate date
							, @Param("day") int day
							, @Param("headcount") int headcount
							, @Param("phoneNumber") String phoneNumber);	
	
	public int deleteBooking(@Param("id") int id);
	
	public Booking checkBooking(@Param("name") String name
								, @Param("phoneNumber") String phoneNumber);
	
}
