package com.jeonpeace.spring.test.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeonpeace.spring.test.seller.domain.Seller;
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
	public String createSeller(@RequestParam("nickname") String nickname
			, @RequestParam("profileImage") String profileImage
			, @RequestParam("temperature") double temperature) {
		
		int count = sellerService.addSeller(nickname, profileImage, temperature);
		
		return "redirect:/seller/search";
	}
	
	@GetMapping("/seller/search")
	public String searchSeller(@RequestParam(name = "id", required = false) Integer id, Model model) {
		
		if(id == null) {
			
			Seller seller = sellerService.getRecentSeller();
			
			model.addAttribute("seller", seller);
			
			return "seller/result";
		}
		
		Seller seller = sellerService.getSellerById(id);
		
		model.addAttribute("seller", seller);
		
		return "seller/result";
	}

	
}
