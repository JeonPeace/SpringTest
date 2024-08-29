package com.jeonpeace.spring.test.jpa.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jeonpeace.spring.test.jpa.domain.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

	public List<Post> findById(int id);
	
	public List<Post> findByCompanyId(@Param("companyId") int companyId);
	
	public List<Post> findByPositionAndType(String position, String type);
	
	public List<Post> findByTypeOrSalaryGreaterThanEqual(String position, int salary);
	
	public List<Post> findTop3ByTypeOrderBySalaryDesc(String type);
	
	public List<Post> findByTypeAndSalaryBetween(String type, int start, int end);
	
	@Query(value="SELECT * FROM `post` WHERE `deadline` > :deadline AND SALARY >= :salary ORDER BY `salary` DESC", nativeQuery=true)
	public List<Post> selectByDeadlineAndSalary(@Param("deadline") LocalDate deadline, @Param("salary") int salary);
}
