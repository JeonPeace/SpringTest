package com.jeonpeace.spring.test.database.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jeonpeace.spring.test.database.domain.Store;

@Mapper
public interface StoreRepository {

	public List<Store> selectStoreList();
	
}
