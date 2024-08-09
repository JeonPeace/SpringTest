package com.jeonpeace.spring.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.jeonpeace.spring.test.mybatis.domain.RealEstate;

@Mapper
public interface RealEstateRepository {

	public RealEstate idSelectRealEstate(@Param("id") int id);
	
	public List<RealEstate> rentSelectRealEstate(@Param("rent") int rent);
	
	public List<RealEstate> areaPriceSelectRealEstate(@Param("area") int area, @Param("price") int price);
	
	public int insertRealEstate(RealEstate realEstate);
	
	public int insertRealEstate2(
			@Param("realtorId") int realtorId
			, @Param("address") String address
			, @Param("area") int area
			, @Param("type") String type
			, @Param("price") int price
			, @Param("rentPrice") Integer rentPrice);
	
	public int updateTypePriceById(
			@Param("id") int id
			, @Param("type") String type
			, @Param("price") int price);
	
	public int deleteById(@Param("id") int id);
	
}
