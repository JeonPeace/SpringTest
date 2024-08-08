package com.jeonpeace.spring.test.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeonpeace.spring.test.mybatis.domain.RealEstate;
import com.jeonpeace.spring.test.mybatis.repository.RealEstateRepository;

@Service
public class RealEstateService {

	@Autowired
	private RealEstateRepository realEstateRepository;
	
	public RealEstate idGetRealEstate(int id) {
		
		RealEstate realEstate = realEstateRepository.idSelectRealEstate(id);
		
		return realEstate;
		
	}
	
	public List<RealEstate> rentGetRealEstate(int rent) {
		
		List<RealEstate> realEstateList = realEstateRepository.rentSelectRealEstate(rent);
		
		return realEstateList;
		
	}
	
	public List<RealEstate> areaPriceGetRealEstate(int area, int price){
		
		List<RealEstate> realEstateList = realEstateRepository.areaPriceSelectRealEstate(area, price);
		
		return realEstateList;
		
	}
	
}
