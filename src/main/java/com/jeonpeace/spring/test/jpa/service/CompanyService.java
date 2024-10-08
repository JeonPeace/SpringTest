package com.jeonpeace.spring.test.jpa.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeonpeace.spring.test.jpa.domain.Company;
import com.jeonpeace.spring.test.jpa.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	public Company addCompany(String name
							, String business
							, String scale
							, int headcount
							, String region) {
		
		Company company = Company.builder()
						.name(name)
						.business(business)
						.scale(scale)
						.headcount(headcount)
						.region(region)
						.build();
		
		
		Company result = companyRepository.save(company);
		
		return result;
	}
	
	public Company updateScaleHeadcount(int id, String scale, int headcount) {
		
		Optional<Company> optionalCompany = companyRepository.findById(id);
		Company company = optionalCompany.orElse(null);
		
		company = company.toBuilder()
						.headcount(headcount)
						.scale(scale)
						.updatedAt(LocalDateTime.now())
						.build();
		
		Company result = companyRepository.save(company);
		
		return result;
	}
	
	public void deleteCompany(int id) {
		
		Optional<Company> optionalCompany = companyRepository.findById(id);
		
//		Company company = optionalCompany.orElse(null);
//		if(company != null) {
//			companyRepository.delete(company);			
//		}
		
//		if(optionalCompany.isPresent()) {
//			companyRepository.delete(optionalCompany.get());
//		}
		
		// null이 아닐때 수행할 기능을 등록
		// c : optionalCompany 객체에 포함된 실제 객체
		optionalCompany.ifPresent(c -> companyRepository.delete(c));
		
	}
	
}
