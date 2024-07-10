package com.sapient.sapient.Callouts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sapient.sapient.HallOfFame.FameRepository;
import com.sapient.sapient.HallOfFame.FameService;
import com.sapient.sapient.HallOfFame.Fames;
import com.sapient.sapient.TalentGuard.Certificates;
import com.sapient.sapient.TalentGuard.Experiences;

@Controller
public class CalloutController {
	
	@Autowired
	CalloutRepository calloutRepository;
	@Autowired
	FameRepository famesrepository;
	@Autowired
	CalloutService calloutservice;
	
	@GetMapping("/home")
	public String home(Model model) {
		Certificates cert = new Certificates();
		model.addAttribute("cert", cert);
		Experiences exp = new Experiences();
		model.addAttribute("exp", exp);
		Fames fame = new Fames();
		model.addAttribute("fame", fame);
		Callout newC = new Callout();
		model.addAttribute("callout", newC);
		model.addAttribute("fames", famesrepository.findAll());
		model.addAttribute("callouts", calloutRepository.findAll());
		return "index";
	}
	
	@PostMapping("/save")
	public String saveCallout(@ModelAttribute("callout") Callout callout, RedirectAttributes redirectAttributes) {
		calloutservice.addCallout(callout);
		redirectAttributes.addFlashAttribute("calloutMessage", "Callout added!");
		return "redirect:/home";
	}
	
}
