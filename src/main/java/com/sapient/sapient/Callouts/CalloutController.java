package com.sapient.sapient.Callouts;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.sapient.sapient.HallOfFame.FameRepository;
import com.sapient.sapient.HallOfFame.FameService;
import com.sapient.sapient.HallOfFame.Fames;
import com.sapient.sapient.SmallImprovements.SmallImprovements;
import com.sapient.sapient.SmallImprovements.SmallImprovementsService;
import com.sapient.sapient.TalentGuard.Certificates;
import com.sapient.sapient.TalentGuard.Experiences;
import com.sapient.sapient.employees.EmployeeService;

@Controller
public class CalloutController {
	
	@Autowired
	CalloutRepository calloutRepository;
	@Autowired
	FameRepository famesrepository;
	@Autowired
	CalloutService calloutservice;
	@Autowired
	SmallImprovementsService smallImprovementsService;
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/home") 
	public String home(Model model) {
		// Pass the HTML blank instances to work with
		Certificates cert = new Certificates();
		model.addAttribute("cert", cert);
		SmallImprovements si = new SmallImprovements();
		model.addAttribute("improvements", si);
		Experiences exp = new Experiences();
		model.addAttribute("exp", exp);
		Fames fame = new Fames();
		model.addAttribute("fame", fame);
		Callout newC = new Callout();
		model.addAttribute("callout", newC);
		// This organises all the 'callouts' by time and reverses them
		List<Callout> sortedCallouts = calloutRepository.findAll();
		Collections.sort(sortedCallouts, Comparator.comparing(Callout::getCalloutDate).reversed());
		// This organises all the 'fames' by time and reverses them
		System.out.println(famesrepository.findAll());
		List<Fames> sortedFames = famesrepository.findAll();
		Collections.sort(sortedFames, Comparator.comparing(Fames::getFameDate).reversed());
		System.out.println(sortedFames);
		// Pass fames and callouts to HTML
		model.addAttribute("callouts", sortedCallouts);
		model.addAttribute("fames", sortedFames);
        model.addAttribute("dueSoonObjectives", smallImprovementsService.getDueSoonObjectives());
        model.addAttribute("nextMeeting", smallImprovementsService.getNextMeeting());
        model.addAttribute("mostRecentFeedback", smallImprovementsService.getMostRecentFeedback());
        model.addAttribute("employees", employeeService.getAllEmployees());
		return "index";
	}
	
	@PostMapping("/save")
	public String saveCallout(@ModelAttribute("callout") Callout callout, RedirectAttributes redirectAttributes) {
		calloutservice.addCallout(callout);
		redirectAttributes.addFlashAttribute("calloutMessage", "Callout added!");
		return "redirect:/home";
	}
	
	@PostMapping("/saveCallout/{id}")
	public String addLike(@PathVariable int id) {
	    Optional<Callout> optionalCallouts = calloutRepository.findById(id);
	    if (optionalCallouts.isPresent()) {
	        Callout hall = optionalCallouts.get();
	        hall.setLikes(hall.getLikes() + 1);
	        calloutRepository.save(hall);
	    } else {
	        System.out.println("Adding Likes failed");
	    }
	    return "redirect:/home";
	}
	
}