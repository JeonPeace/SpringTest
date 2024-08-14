package com.jeonpeace.spring.test.realtor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeonpeace.spring.test.realtor.domain.Realtor;
import com.jeonpeace.spring.test.realtor.service.RealtorService;

@Controller
public class RealtorController {

	@Autowired
	private RealtorService realtorService;
	
	@PostMapping("/realtor/create")
	public String createRealtor(
//								@RequestParam("office") String office
//								, @RequestParam("phoneNumber") String phoneNumber
//								, @RequestParam("address") String address
//								, @RequestParam("grade") String grade
								@ModelAttribute Realtor realtor
								, Model model) {
		
//		Realtor realtor = new Realtor();
//		realtor.setOffice(office);
//		realtor.setPhoneNumber(phoneNumber);
//		realtor.setAddress(address);
//		realtor.setGrade(grade);
		
		realtorService.addRealtor(realtor);
		
		model.addAttribute("result", realtor);
		
		return "realtor/realtorinfo";
		
	}
	
	@RequestMapping("/realtor/input")
	public String inputRealtor() {
		
		return "realtor/realtorCreate";
	}
	
}
