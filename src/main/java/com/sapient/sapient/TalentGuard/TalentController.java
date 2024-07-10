package com.sapient.sapient.TalentGuard;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sapient.sapient.Callouts.Callout;

import jakarta.transaction.Transactional;

@Controller
public class TalentController {

	@Autowired
	TalentRepository talentrepository;
	@Autowired
	TalentService talentservice;

	@GetMapping("/talentguards")
	public String allTalents(Model model) {
		model.addAttribute("talents", talentrepository.findAll());
		return "all_talents";
	}
	
	@PostMapping("/save_cert")
    public String saveCert(@ModelAttribute("cert") Certificates cert, RedirectAttributes redirectAttributes) {
        talentservice.saveCert(cert);
        redirectAttributes.addFlashAttribute("talentMessage", "Certificate added!");
        return "redirect:/home";
    }
	
	@PostMapping("/save_exp")
	public String saveCert(@ModelAttribute("exp") Experiences exp, RedirectAttributes redirectAttributes) {
		talentservice.saveExp(exp);
        redirectAttributes.addFlashAttribute("talentMessage", "Experience added!");
        return "redirect:/home";
	}
	
}
