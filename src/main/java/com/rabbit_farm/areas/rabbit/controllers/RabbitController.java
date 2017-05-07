package com.rabbit_farm.areas.rabbit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rabbit")
public class RabbitController {

	@GetMapping("/create")
	public String getRabbitCreatePage(Model model) {

		return "rabbit/create";
	}

}
