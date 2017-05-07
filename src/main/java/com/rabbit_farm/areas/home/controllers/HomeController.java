package com.rabbit_farm.areas.home.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String redirectToRabbitCreatePage() {
		return "redirect:/rabbit/create";
	}
}
