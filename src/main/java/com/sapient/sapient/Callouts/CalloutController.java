package com.sapient.sapient.Callouts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sapient.sapient.HallOfFame.FameRepository;
import com.sapient.sapient.HallOfFame.Fames;
import com.sapient.sapient.TalentGuard.Certificates;
import com.sapient.sapient.TalentGuard.Experiences;

@Controller
public class CalloutController {
	
	@Autowired
	CalloutRepository calloutRepository;
	@Autowired
	FameRepository famesrepository;
	
	@GetMapping("/home")
	public String home(Model model) {
		Certificates cert = new Certificates();
		model.addAttribute("cert", cert);
		Experiences exp = new Experiences();
		model.addAttribute("exp", exp);
		Fames fame = new Fames();
		model.addAttribute("fame", fame);
		model.addAttribute("fames", famesrepository.findAll());
		model.addAttribute("callouts", calloutRepository.findAll());
		return "index";
	}
	
	@GetMapping("/addcallout")
	public String addCallout(Model model) {
		Callout newC = new Callout();
		model.addAttribute("callout", newC);
		return "add_callout";
	}
	
	@PostMapping("/save")
	public String saveCallout(@ModelAttribute("callout") Callout callout) {
		calloutRepository.save(callout);
		return "redirect:/home";
	}
	
}
