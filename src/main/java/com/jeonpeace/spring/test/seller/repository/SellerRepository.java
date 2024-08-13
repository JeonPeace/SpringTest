package com.jeonpeace.spring.test.seller.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jeonpeace.spring.test.seller.domain.Seller;

@Mapper
public interface SellerRepository {

	public int insertSeller(@Param("nickname") String nickname
						, @Param("profileImage") String profileImage
						, @Param("temperature") double temperature);
	
	
	public Seller selectRecentSeller();
	
	public Seller selectSellerById(@Param("id") Integer id);
	
}
