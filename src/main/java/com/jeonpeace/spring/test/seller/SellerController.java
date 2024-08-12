package com.jeonpeace.spring.test.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeonpeace.spring.test.seller.service.SellerService;

@Controller
public class SellerController {

	@Autowired
	private SellerService sellerService;
	
	@GetMapping("/seller/new")
	public String sellerForm() {
		
		return "seller/add";
	}
	
	@GetMapping("/seller/create")
	@ResponseBody
	public String createSeller(@RequestParam("nickname") String nickname
			, @RequestParam("profileImage") String profileImage
			, @RequestParam("temperature") double temperature) {
		
		int count = sellerService.addSeller(nickname, profileImage, temperature);
		
		return "입력 성공 : " + count;
	}
	
	@GetMapping("/seller/recent")
	public String recentSeller() {
		
		
		return "seller/recent";
	}
	
}
