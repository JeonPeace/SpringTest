package com.jeonpeace.spring.test.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeonpeace.spring.test.ajax.domain.Favorite;
import com.jeonpeace.spring.test.ajax.repository.FavoriteRepository;

@Service
public class FavoriteService {

	@Autowired
	private FavoriteRepository favoriteRepository;
	
	public List<Favorite> getFavoriteList() {
		
		List<Favorite> favoriteList = favoriteRepository.selectFavoriteList();
		
		return favoriteList;
	}
	
	public int addFavorite(String name, String url) {
		
		int count = favoriteRepository.insertFavorite(name, url);
		
		return count;
	}
	
	public boolean checkFavorite(String url) {
		
		int count = favoriteRepository.selectSameUrl(url);
		
		if(count == 0) {
			// 중복 안됨
			return false;
		}else {
			// 중복됨
			return true;
		}
	}
	
	public int deleteFavorite(int id) {
		
		int count = favoriteRepository.deleteFavorite(id);
		
		return count;
	}
	
}
