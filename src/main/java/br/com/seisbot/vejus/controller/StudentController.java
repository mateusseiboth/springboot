package br.com.seisbot.vejus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
	
	@GetMapping("/")
	public String listStudent() {
		return "/listStudent";
	}

}
