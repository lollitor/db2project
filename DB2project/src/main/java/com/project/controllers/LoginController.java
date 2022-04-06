package com.project.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.entities.Consumer;
import com.project.entities.ServicePackage;
import com.project.entities.Subscription;
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
	
	@GetMapping("/2")
	public String goToLoginForm2(Model model) {
		model.addAttribute("user", new Consumer());
		return "login2";
	}
	
	@PostMapping
	public String goToHome(HttpSession session, Model model, @ModelAttribute(name="user") Consumer user) {
	    Consumer user2 =consumerRepo.checkLogin(user.getUsername(), user.getPassword());
		if(user2!=null) {
			List<Subscription> subscriptions = new ArrayList<>();
			subscriptions = user2.getSubscriptions(); //le devi filtrare e prendere solo quelle rejected (fai una named query)
			ServicePackage chosenService = new ServicePackage();
			List<ServicePackage> services = serviceRepo.findAll();
			model.addAttribute("chosenService", chosenService );
			model.addAttribute("services", services);
			model.addAttribute("subscriptions", subscriptions);
			//model.addAttribute("user", user2);
			session.setAttribute("user", user2);
			
			return "home";
		}
		return "failed";
	}
	
	@PostMapping("/2")
	public String goToConfirmation(HttpSession session, Model model, @ModelAttribute(name="user") Consumer user) {
	    Consumer user2 =consumerRepo.checkLogin(user.getUsername(), user.getPassword());
		if(user2!=null) {
			Subscription sub = (Subscription) session.getAttribute("subscription");
			sub.setConsumer(user2);
			model.addAttribute("subscription", sub);
			session.setAttribute("user", user2);
			session.setAttribute("subscription", sub);
			int optionalPrice = 0;
			for (int i =0; i< sub.getOptionalProducts().size(); i++) {
				optionalPrice = (int) (optionalPrice + sub.getOptionalProducts().get(i).getMonthlyFee());
			}
			int price = (int) (sub.getValidityPeriod().getMonths()*(sub.getValidityPeriod().getMonthlyFee()+
					optionalPrice));
			model.addAttribute("price", price);
			
			return "confirmation";
		}
		return "failed";
	}

}
