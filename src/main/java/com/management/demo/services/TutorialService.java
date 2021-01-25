package com.management.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.management.demo.repositories.TutorialRepository;
import java.util.Optional;
import com.management.demo.models.Tutorial;

@Service
public class TutorialService {
	
	@Autowired
	TutorialRepository repository;
	
	public List<Tutorial> getAllTutorials(String title) {
	    if (title == null)
	        return repository.findAll();
	      else
	        return repository.findByTitleContaining(title);
	}
	
	 public Optional<Tutorial> getTutorialById(long id){
		 return repository.findById(id);
	 }
	 
	 public Tutorial createTutorial(Tutorial tutorial) {
		   return  repository.save(tutorial);
		    
		  }
	 

	  public Tutorial updateTutorial( long id,Tutorial tutorial) {
		    Optional<Tutorial> tutorialData = repository.findById(id);
		    if (tutorialData.isPresent()) {
		      Tutorial _tutorial = tutorialData.get();
		      _tutorial.setTitle(tutorial.getTitle());
		      _tutorial.setDescription(tutorial.getDescription());
		      _tutorial.setPublished(tutorial.getPublished());
		      return repository.save(_tutorial);
		    }
		    return null;
		    
	  }
	  

	  public void deleteTutorial( long id) {
	    
	      repository.deleteById(id);
	     
	  }


	  public void deleteAllTutorials() {
	
	      repository.deleteAll();
	  }
	
	  public List<Tutorial> findByPublished() {
	   
	     return  repository.findByPublished(true);

	    
	  }

	

}
