package com.management.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.management.demo.controllers.TutorialController;
import com.management.demo.models.Tutorial;

@SpringBootApplication
public class BackendSpringBootAngularApplication {
	private static TutorialController controller;

	public static void main(String[] args) {
		ApplicationContext applicationContext=  SpringApplication.run(BackendSpringBootAngularApplication.class, args);
		controller = (TutorialController) applicationContext.getBean("tutorialController");
		System.out.println("create tut 1");
		controller.createTutorial(new Tutorial("tutorial1", "description1", true));
		System.out.println("create tut 2");
		controller.createTutorial(new Tutorial("tutorial2", "description2", false));
		System.out.println("view All tuts ");
		controller.getAllTutorials("").getBody().forEach(System.out::println);
		System.out.println("update tut 1");
		controller.updateTutorial(1, new Tutorial("tutorial1modif", "description1modif", false));
		System.out.println("get tut 1");
		controller.getTutorialById(1).getBody().toString();
		System.out.println("delete tut 2");
		controller.deleteTutorial(2);
		System.out.println("view All tuts again");
		controller.getAllTutorials("").getBody().forEach(System.out::println);
		
	}

}
