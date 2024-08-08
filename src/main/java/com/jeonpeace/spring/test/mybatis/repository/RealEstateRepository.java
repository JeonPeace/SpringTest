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
	
}
