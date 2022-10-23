package com.aungpaing.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aungpaing.model.entities.Employee;
import com.aungpaing.service.EmployeeService;

@Controller
//@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/employees")
	public String goHome(Model model) {
		model.addAttribute("employees", service.findAll());
		return "index";
	}

	@GetMapping("/employees/add")
	public String goAddPage(Model model) {

		model.addAttribute("employee_obj", new Employee());
		model.addAttribute("cities", new String[] { "Yangon", "Mandalay", "Pyin Oo Lwin" });
		return "emp-add";

	}

	@PostMapping("/employees/save")
	public String saveEmployee(@Valid @ModelAttribute("employee_obj") Employee employee, BindingResult result) {

		if (employee.getName() != null && employee.getName().equals("virus")) {
			ObjectError error = new ObjectError("global", "It does not allow");
			result.addError(error);
		}
		if (result.hasErrors()) {
			return "emp-add";
		}
//		System.out.println(employee);
		service.save(employee);
		return "redirect:/employees";
	}

	@GetMapping("/employees/{empId}")
	public String goEditPage(Model model, @PathVariable("empId") int id) {
		var employee = service.findById(id);
		model.addAttribute("employee_obj", employee);
		model.addAttribute("cities", new String[] { "Yangon", "Mandalay", "Pyin Oo Lwin" });
		return "emp-add";
	}

	@GetMapping("/employees/delete/{id}")
	public String deleteEmployee(@PathVariable("id") int empId) {
		service.deleteById(empId);
		return "emp-add";
	}
}
