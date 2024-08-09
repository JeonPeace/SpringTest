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
@RequestMapping("/mybatis/real-estate")
public class RealEstateController {

	@Autowired
	private RealEstateService realEstateService;
	
	@RequestMapping("/1")
	@ResponseBody
	public RealEstate idRealEstate(@RequestParam("id") int id) {
		
		RealEstate realEstate = realEstateService.idGetRealEstate(id);
		
		return realEstate;
		
	}
	
	@RequestMapping("/2")
	@ResponseBody
	public List<RealEstate> rentRealEstate(@RequestParam("rent") int rent) {
		
		List<RealEstate> realEstateList = realEstateService.rentGetRealEstate(rent);
		
		return realEstateList;
		
	}
	
	@RequestMapping("/3")
	@ResponseBody
	public List<RealEstate> areaPriceRealEstate(@RequestParam("area") int area, @RequestParam("price") int price) {
		
		List<RealEstate> realEstateList = realEstateService.areaPriceGetRealEstate(area, price);
		
		return realEstateList;
		
	}
	
	@RequestMapping("/4")
	@ResponseBody
	public String addRealEstate() {
		
		RealEstate realEstate = new RealEstate();
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		realEstate.setRentPrice(null);
		
		int count = realEstateService.addRealEstate(realEstate);
		
		return "입력 성공 : " + count;
	}
	
	@RequestMapping("/5")
	@ResponseBody
	public String addRealEstate2(@RequestParam("realtorId") int realtorId) {
		
		int count = realEstateService.addRealEstate2(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		
		return "입력 성공 : " + count;
		
	}
	
	@RequestMapping("/6")
	@ResponseBody
	public String updateTypePriceById(
			@RequestParam("id") int id
			, @RequestParam("type") String type
			, @RequestParam("price") int price) {
		
		int count = realEstateService.updateTypePriceById(id, type, price);
		
		return "수정 성공 : " + count;
		
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String deleteById(@RequestParam("id") int id) {
		
		int count = realEstateService.deleteById(id);
		
		return "삭제 성공 : " + count;
		
	}
}
