package com.sapient.sapient.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sapient.sapient.TalentGuard.Certificates;

@Controller
public class EmployeeController {

		@Autowired
		EmployeeRepository employeeRepository;
		@Autowired
		EmployeeService employeeservice;
		
//		@PostMapping("/save_employee")
//	    public String saveCert(@ModelAttribute("employee") Employee employee, RedirectAttributes redirectAttributes) {
//			employeeservice.addEmployee(employee);
//	        redirectAttributes.addFlashAttribute("talentMessage", "Employee added!");
//	        return "redirect:/home";
//	    }
		
		@GetMapping("/employees")
		public String allCallouts(Model model) {
			model.addAttribute("employees", employeeRepository.findAll());
			return "all_employees";
		}
}
