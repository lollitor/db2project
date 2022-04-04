package com.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.project.entities.Consumer;


@Controller
@RequestMapping("")
@SessionAttributes({"user"})   // setta l'user per l'intera sessione e non solo per una request scope
public class MainController {
	

	
	@GetMapping
	public String goToIndex(Model model) {
		Consumer user = new Consumer();
		model.addAttribute("user",user);
		System.out.println("USER SETTATO NELLA SESSION");
		return "index";
	}

}


// token GitHub: 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