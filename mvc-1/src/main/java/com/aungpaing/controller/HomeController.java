package com.aungpaing.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(method = RequestMethod.GET, name = "/home")
	@GetMapping("/home")
	public String goHome() {
		return "return-type"; // Logical Name (template/return-type.html)
	}

	@GetMapping("/string")
	public String goString(Model m, @RequestParam(name = "userName", required = false) String name) {
		m.addAttribute("time", LocalTime.now());
		m.addAttribute("name", name);
		return "string-page";
	}

	@GetMapping("/void")
	public void goVoid() {

	}

	@GetMapping("/mv")
	public ModelAndView goModelanAndView() {
		ModelMap m = new ModelMap();
		m.addAttribute("date", LocalDate.now());
		m.put("msg", "This is <b> Spring MVC </b>");
		ModelAndView obj = new ModelAndView("view-with-model", m);
		return obj;
	}

	@GetMapping("/detail")
	public String detail(@PathVariable int id) {
		return "void";
	}
}
