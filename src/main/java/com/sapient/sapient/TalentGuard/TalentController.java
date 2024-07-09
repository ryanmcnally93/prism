package com.sapient.sapient.TalentGuard;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TalentController {

	@Autowired
	TalentRepository talentrepository;

	@GetMapping("/talentguards")
	public String allTalents(Model model) {
		model.addAttribute("talents", talentrepository.findAll());
		return "all_talents";
	}
	
}
