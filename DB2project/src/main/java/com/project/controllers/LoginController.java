package com.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.entities.Consumer;
import com.project.entities.ServicePackage;
import com.project.repositories.ConsumerRepository;
import com.project.repositories.ServicePackageRepository;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	ConsumerRepository consumerRepo;
	
	@Autowired
	ServicePackageRepository serviceRepo;
	
	@GetMapping
	public String goToLoginForm(Model model) {
		model.addAttribute("user", new Consumer());
		return "login";
	}
	
	@PostMapping
	public String goToHome(@ModelAttribute(name="user") Consumer user, Model model) {
		Consumer user2 =consumerRepo.checkLogin(user.getUsername(), user.getPassword());
		if(user2!=null) {
			List<ServicePackage> services = serviceRepo.getServices();
			model.addAttribute("services", services);
			model.addAttribute("user", user2);
			return "home";
		}
		return "failed";
	}

}
