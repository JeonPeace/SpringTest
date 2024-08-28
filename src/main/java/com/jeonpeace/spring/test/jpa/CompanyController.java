package com.jeonpeace.spring.test.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeonpeace.spring.test.jpa.domain.Company;
import com.jeonpeace.spring.test.jpa.service.CompanyService;

@Controller
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/jpa/company/create")
	@ResponseBody
	public List<Company> createCompany() {
		
		List<Company> companyList = new ArrayList<>();
		
		Company company1 = companyService.addCompany("넥손", "컨텐츠 게임", "대기업", 3585, "서울시 송파구");
		companyList.add(company1);
		
		Company company2 = companyService.addCompany("버블팡", "여신 금융업", "대기업", 6834, "서울시 송파구");
		companyList.add(company2);
		
		return companyList;
	}
	
	@GetMapping("/jpa/company/update")
	@ResponseBody
	public Company updateCompany() {
		
		Company company = companyService.updateScaleHeadcount(8, "중소기업", 34);
		
		return company;
	}
	
	@GetMapping("/jpa/company/delete")
	@ResponseBody
	public String deleteCompany() {
		
		companyService.deleteCompany(8);
		
		return "수행 완료!!";
	}
	
}
