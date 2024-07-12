package com.sapient.sapient.HallOfFame;
import java.time.LocalDate;
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
import com.sapient.sapient.Callouts.Callout;
import jakarta.transaction.Transactional;

@Controller
public class FameController {

	@Autowired
	FameRepository famerepository;
	@Autowired
	FameService fameservice;
	
	@PostMapping("/save_fame")
    public String saveFame(@ModelAttribute("fame") Fames fame, RedirectAttributes redirectAttributes) {
        fameservice.addFame(fame);
        redirectAttributes.addFlashAttribute("fameMessage", "Fame added!");
        return "redirect:/home";
    }
	
	@PostMapping("/saveFame/{id}")
	public String addLike(@PathVariable int id) {
	    Optional<Fames> optionalHallOfFame = famerepository.findById(id);
	    if (optionalHallOfFame.isPresent()) {
	        Fames hall = optionalHallOfFame.get();
	        hall.setLikes(hall.getLikes() + 1);
	        famerepository.save(hall);
	    } else {
	        System.out.println("Adding Likes failed");
	    }
	    return "redirect:/home";
	}
	
}