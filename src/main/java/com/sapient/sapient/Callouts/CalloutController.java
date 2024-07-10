package com.sapient.sapient.Callouts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sapient.sapient.TalentGuard.Certificates;
import com.sapient.sapient.TalentGuard.Experiences;

@Controller
public class CalloutController {
	
	@Autowired
	CalloutRepository calloutRepository;
	
	@GetMapping("/home")
	public String home(Model model) {
		Certificates cert = new Certificates();
		model.addAttribute("cert", cert);
		Experiences exp = new Experiences();
		model.addAttribute("exp", exp);
		return "index";
	}
	
	@GetMapping("/callouts")
	public String allCallouts(Model model) {
		model.addAttribute("callouts", calloutRepository.findAll());
		return "all_callouts";
	}
	
	@GetMapping("/addcallout")
	public String addCallout(Model model) {
		Callout newC = new Callout();
		model.addAttribute("callout", newC);
		return "add_callout";
	}
	
	@PostMapping("/save")
	public String saveCallout(@ModelAttribute("person") Callout callout) {
		calloutRepository.save(callout);
		return "redirect:/callouts";
	}
	
}