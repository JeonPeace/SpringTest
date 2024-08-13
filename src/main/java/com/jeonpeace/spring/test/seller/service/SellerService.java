package com.jeonpeace.spring.test.seller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeonpeace.spring.test.seller.domain.Seller;
import com.jeonpeace.spring.test.seller.repository.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository sellerRepository;
	
	public int addSeller(String nickname
						, String profileImage
						, double temperature) {
		
		int count = sellerRepository.insertSeller(nickname, profileImage, temperature);
		
		return count;
	}
	
	public Seller getRecentSeller() {
		
		Seller recentSeller = sellerRepository.selectRecentSeller();
		
		return recentSeller;
		
	}
	
	public Seller getSellerById(Integer id) {
		
		Seller searchedSeller = sellerRepository.selectSellerById(id);
		
		return searchedSeller;
		
	}
}
