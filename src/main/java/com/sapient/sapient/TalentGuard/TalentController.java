package com.sapient.sapient.TalentGuard;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sapient.sapient.Callouts.Callout;

@Controller
public class TalentController {

	@Autowired
	TalentRepository talentrepository;

	@GetMapping("/talentguards")
	public String allTalents(Model model) {
		model.addAttribute("talents", talentrepository.findAll());
		return "all_talents";
	}
	
	@PostMapping("/save_cert")
	public String saveCert(@ModelAttribute("cert") Certificates cert) {
		TalentGuards t = new TalentGuards(1, cert);
		talentrepository.save(t);
		return "redirect:/home";
	}
	
	@PostMapping("/save_exp")
	public boolean saveCert(@ModelAttribute("cert") Experiences exp) {
		TalentGuards t = new TalentGuards(1, exp);
		talentrepository.save(t);
		return true;
	}
	
}
