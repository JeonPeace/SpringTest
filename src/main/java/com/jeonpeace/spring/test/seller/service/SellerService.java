package com.jeonpeace.spring.test.seller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
}
