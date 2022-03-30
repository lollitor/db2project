package com.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.entities.Consumer;
import com.project.repositories.ConsumerRepository;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	ConsumerRepository consumerRepo;
	
	@GetMapping
	public String goToRegistrationForm(Model model) {
		model.addAttribute("user", new Consumer());
		return "registration";
	}
	
	@PostMapping
	public String registrateConsumer (Consumer user) { //si può fare meglio il passaggio della variabile
		
		consumerRepo.save(user);
		return "success";
	}

}
