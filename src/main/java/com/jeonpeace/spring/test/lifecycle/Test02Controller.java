package com.jeonpeace.spring.test.lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lifecycle/test02")
public class Test02Controller {

	@RequestMapping("/1")
	public List<Map<String, Object>> mapListResponse(){
		
		Map<String, Object> movieMap1 = new HashMap<>();
		
		movieMap1.put("rate", 15);
		movieMap1.put("director", "봉준호");
		movieMap1.put("time", 131);
		movieMap1.put("title", "기생충");
		
		Map<String, Object> movieMap2 = new HashMap<>();
		
		movieMap2.put("rate", 0);
		movieMap2.put("director", "로베르토 베니니");
		movieMap2.put("time", 116);
		movieMap2.put("title", "인생은 아름다워");
		
		Map<String, Object> movieMap3 = new HashMap<>();
		
		movieMap3.put("rate", 12);
		movieMap3.put("director", "크리스토퍼 놀란");
		movieMap3.put("time", 147);
		movieMap3.put("title", "인셉션");
		
		Map<String, Object> movieMap4 = new HashMap<>();
		
		movieMap4.put("rate", 19);
		movieMap4.put("director", "윤종빈");
		movieMap4.put("time", 133);
		movieMap4.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
		
		Map<String, Object> movieMap5 = new HashMap<>();
		
		movieMap5.put("rate", 15);
		movieMap5.put("director", "프란시스 로렌스");
		movieMap5.put("time", 137);
		movieMap5.put("title", "헝거게임");
		
		List<Map<String, Object>> movieList = new ArrayList<>();
		
		movieList.add(movieMap1);
		movieList.add(movieMap2);
		movieList.add(movieMap3);
		movieList.add(movieMap4);
		movieList.add(movieMap5);
		
		return movieList;
		
	}
	
	@RequestMapping("/2")
	public List<Board> boardListResponse() {
		
		Board board01 = new Board("안녕하세요 가입인사 드립니다.", "hangulu", "안녕하세요. 가입했어요.");
		Board board02 = new Board("헐 대박", "bada", "오늘 목요일이었어...");
		Board board03 = new Board("오늘 데이트 한 이야기 해드릴게요.", "dulumary", "....");
		
		List<Board> boardList = new ArrayList<>();
		
		boardList.add(board01);
		boardList.add(board02);
		boardList.add(board03);
		
		return boardList;
		
	}
	
	@RequestMapping("/3")
	public ResponseEntity<Board> entityResponse(){
		
		Board board01 = new Board("안녕하세요 가입인사 드립니다.", "hangulu", "안녕하세요. 가입했어요.");
		
		return new ResponseEntity(board01, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
}
