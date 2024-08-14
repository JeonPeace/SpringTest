package com.jeonpeace.spring.test.realtor.repository;

import org.apache.ibatis.annotations.Mapper;

import com.jeonpeace.spring.test.realtor.domain.Realtor;

@Mapper
public interface RealtorRepository {

	public int insertRealtor(Realtor realtor);
	
}
