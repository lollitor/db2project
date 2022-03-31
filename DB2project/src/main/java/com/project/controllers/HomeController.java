package com.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.entities.ServicePackage;
import com.project.repositories.ServicePackageRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	ServicePackageRepository serviceRepo;
	
	
	
	@GetMapping
	public String goToHome(Model model) {
		List<ServicePackage> services = serviceRepo.getServices();
		model.addAttribute("services",services);
		model.addAttribute("user", null);
		return "home";
	}

}
