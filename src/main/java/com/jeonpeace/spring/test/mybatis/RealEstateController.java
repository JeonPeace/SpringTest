package com.jeonpeace.spring.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeonpeace.spring.test.mybatis.domain.RealEstate;
import com.jeonpeace.spring.test.mybatis.service.RealEstateService;

@Controller
public class RealEstateController {

	@Autowired
	private RealEstateService realEstateService;
	
	@RequestMapping("/mybatis/real-estate/1")
	@ResponseBody
	public RealEstate idRealEstate(@RequestParam("id") int id) {
		
		RealEstate realEstate = realEstateService.idGetRealEstate(id);
		
		return realEstate;
		
	}
	
	@RequestMapping("/mybatis/real-estate/2")
	@ResponseBody
	public List<RealEstate> rentRealEstate(@RequestParam("rent") int rent) {
		
		List<RealEstate> realEstateList = realEstateService.rentGetRealEstate(rent);
		
		return realEstateList;
		
	}
	
	@RequestMapping("/mybatis/real-estate/3")
	@ResponseBody
	public List<RealEstate> areaPriceRealEstate(@RequestParam("area") int area, @RequestParam("price") int price) {
		
		List<RealEstate> realEstateList = realEstateService.areaPriceGetRealEstate(area, price);
		
		return realEstateList;
		
	}
	
}
