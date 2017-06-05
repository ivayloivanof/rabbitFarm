package com.rabbit_farm.areas.rabbit.controllers;

import com.rabbit_farm.areas.rabbit.services.RabbitService;
import com.rabbit_farm.configurations.address.PagesTitle;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rabbit")
public class RabbitController {

	private RabbitService rabbitService;

	@GetMapping("/show/all")
	public String getRabbitShowPage(Model model) {
		model.addAttribute("title", PagesTitle.RABBIT_ALL);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		return "rabbit/show";
	}

	@GetMapping("/create")
	public String getRabbitCreatePage(Model model) {

		return "rabbit/create";
	}

}
