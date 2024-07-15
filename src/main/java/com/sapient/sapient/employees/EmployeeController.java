package com.sapient.sapient.employees;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.sapient.sapient.HallOfFame.Fames;
import com.sapient.sapient.Callouts.Callout;
import com.sapient.sapient.Callouts.CalloutRepository;
import com.sapient.sapient.HallOfFame.FameRepository;
import com.sapient.sapient.TalentGuard.Certificates;

@Controller
public class EmployeeController {

		@Autowired
		EmployeeRepository employeeRepository;
		@Autowired
		EmployeeService employeeservice;
		@Autowired
		FameRepository famerepo;
		@Autowired
		CalloutRepository calloutrepo;
		
		@PostMapping("/save_comment/{type}/{id}")
		public String addComment(@PathVariable int id,@PathVariable String type, @RequestParam String commenting) {
			if(type.equals("callout")) {
				Optional<Callout> optionalCallout = calloutrepo.findById(id);
			    if (optionalCallout.isPresent()) {
			        Callout c = optionalCallout.get();
			        c.addToComments(commenting);
			        calloutrepo.save(c);
			        System.out.println("Success!");
			    } else {
			        System.out.println("Adding Callout failed");
			    }
			    return "redirect:/home";
			} else {
				Optional<Fames> optionalFame = famerepo.findById(id);
			    if (optionalFame.isPresent()) {
			        Fames f = optionalFame.get();
			        f.addToComments(commenting);
			        famerepo.save(f);
			        System.out.println("Success!");
			    } else {
			        System.out.println("Adding Fame failed");
			    }
			    return "redirect:/home";
			}
		    
		}
		
//		@PostMapping("/save_employee")
//	    public String saveCert(@ModelAttribute("employee") Employee employee, RedirectAttributes redirectAttributes) {
//			employeeservice.addEmployee(employee);
//	        redirectAttributes.addFlashAttribute("talentMessage", "Employee added!");
//	        return "redirect:/home";
//	    }
		
//		@GetMapping("/employees")
//		public String allCallouts(Model model) {
//			model.addAttribute("employees", employeeRepository.findAll());
//			return "all_employees";
//		}
}
