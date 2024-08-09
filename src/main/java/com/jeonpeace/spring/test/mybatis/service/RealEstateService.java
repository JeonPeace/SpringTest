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
	
	public int addRealEstate(RealEstate realEstate) {
		
		int count = realEstateRepository.insertRealEstate(realEstate);
		
		return count;
	}
	
	public int addRealEstate2(
			int realtorId
			, String address
			, int area
			, String type
			, int price
			, Integer rentPrice) {
		
		int count = realEstateRepository.insertRealEstate2(realtorId, address, area, type, price, rentPrice);
		
		return count;
		
	}
	
	public int updateTypePriceById(
			int id
			, String type
			, int price) {
		
		int count = realEstateRepository.updateTypePriceById(id, type, price);
		
		return count;
	}
	
	public int deleteById(int id) {
		
		int count = realEstateRepository.deleteById(id);
		
		return count;
		
	}
	
}
