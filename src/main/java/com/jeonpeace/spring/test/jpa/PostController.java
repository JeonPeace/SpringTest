package com.jeonpeace.spring.test.jpa;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeonpeace.spring.test.jpa.domain.Post;
import com.jeonpeace.spring.test.jpa.repository.PostRepository;

@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostRepository postRepository;

	@GetMapping("/find")
	@ResponseBody
	public List<Post> find(@RequestParam("deadline") LocalDate deadline, @RequestParam("salary") int salary){
		
//		@RequestParam("companyId") int companyId
		
		List<Post> postList = null;
		
//		postList = postRepository.findById(8);
//		postList = postRepository.findByCompanyId(companyId);
//		postList = postRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
//		postList = postRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
//		postList = postRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
//		postList = postRepository.findByTypeAndSalaryBetween("정규직", 7000, 8000);
		postList = postRepository.selectByDeadlineAndSalary(deadline, salary);
		
		return postList;
	}
	
}
