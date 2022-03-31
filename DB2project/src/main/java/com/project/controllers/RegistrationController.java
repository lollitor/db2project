package com.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String registrateConsumer (@ModelAttribute(name="user") Consumer user) {
		
		try {
			consumerRepo.save(user);
		} catch (Exception e) {
			return "failedRegistration";
		}
		
		return "success";
	}

}
