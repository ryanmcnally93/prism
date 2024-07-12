package com.sapient.sapient.SmallImprovements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class SmallImprovementsController {
	
	@Autowired
	SmallImprovementsRepository smallImprovementsRepository;
    @Autowired
    SmallImprovementsService smallImprovementsService;
	
	@GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("dueSoonObjectives", smallImprovementsService.getDueSoonObjectives());
        model.addAttribute("nextMeeting", smallImprovementsService.getNextMeeting());
        model.addAttribute("mostRecentFeedback", smallImprovementsService.getMostRecentFeedback());
        return "index";
    }

    @GetMapping
    public List<SmallImprovements> getAllImprovements() {
        return smallImprovementsService.getAllImprovements();
    }

    @GetMapping("/{id}")
    public SmallImprovements getImprovementById(@PathVariable int id) {
        return smallImprovementsService.getImprovementById(id);
    }

    @PostMapping
    public SmallImprovements createImprovement(@RequestBody SmallImprovements smallImprovements) {
        return smallImprovementsService.saveImprovement(smallImprovements);
    }

    @PutMapping("/{id}")
    public SmallImprovements updateImprovement(@PathVariable int id, @RequestBody SmallImprovements smallImprovements) {
        SmallImprovements existingImprovement = smallImprovementsService.getImprovementById(id);
        if (existingImprovement != null) {
            existingImprovement.setObjectives(smallImprovements.getObjectives());
            existingImprovement.setMeetings(smallImprovements.getMeetings());
            existingImprovement.setFeedback(smallImprovements.getFeedback());
            return smallImprovementsService.saveImprovement(existingImprovement);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteImprovement(@PathVariable int id) {
    	smallImprovementsService.deleteImprovement(id);
    }
}
