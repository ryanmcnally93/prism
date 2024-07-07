package com.example.demo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {
	@Autowired
	PersonRepository personRepository;
	
	@GetMapping("/home")
	public String home(Model model) {
		return "index";
	}
	
	@GetMapping("/users")
	public String allUsers(Model model) {
		model.addAttribute("users", personRepository.findAll());
		return "allUsers";
	}
	
	@GetMapping("/addnew")
	public String addNewEmployee(Model model) {
		Person newPerson = new Person();
		model.addAttribute("person", newPerson);
		return "addUser";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("person") Person person) {
		personRepository.save(person);
		return "redirect:/users";
	}
}
