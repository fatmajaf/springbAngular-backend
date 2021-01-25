package com.management.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.demo.models.Tutorial;
@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long>{
	List<Tutorial> findByPublished(boolean published);
	List<Tutorial> findByTitleContaining(String title);

}
