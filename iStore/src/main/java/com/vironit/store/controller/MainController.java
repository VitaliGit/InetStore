package com.vironit.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String redirectPage() {
		return "proceed";
	}
	@GetMapping("/login")
	public String homePage() {
		return "main";
	}

	@GetMapping("/access_prohibited")
	public String denialPage() {
		return "access_prohibited";
	}

}
