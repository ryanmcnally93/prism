package com.sapient.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

		@Autowired
		EmployeeRepository employeeRepository;
		
		
		@GetMapping("/employees")
		public String allCallouts(Model model) {
			model.addAttribute("employees", employeeRepository.findAll());
			return "all_employees";
		}
}
