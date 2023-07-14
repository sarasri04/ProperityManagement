package com.market.simplified.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class loginController {

	String appName = "SSLF";
	@GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("appName", appName);
        return "login";
    }

	@GetMapping("/registerPage")
    public String registerPage(Model model) {
        model.addAttribute("appName", appName);
        return "registerPage";
    }
	
	}

