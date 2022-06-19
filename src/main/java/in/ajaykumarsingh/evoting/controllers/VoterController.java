package in.ajaykumarsingh.evoting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import in.ajaykumarsingh.evoting.services.VoterService;

@Controller
@RequestMapping("/voter")
public class VoterController {

	@Autowired
	private VoterService voterService;

	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("elections", voterService.getActiveElections(getCurrentUSerEmail()));
		return "voter/index";
	}

	@GetMapping("/electiondetails/{id}")
	public String loadElectionDetails(@PathVariable("id") int id, Model model) {
		model.addAttribute("votemodel", voterService.getElectionDetails(id, getCurrentUSerEmail()));
		return "voter/electionDetails";
	}

	@GetMapping("/vote/{electionId}/{candidateId}")
	public String loadElectionDetails(@PathVariable("electionId") int electionId,
			@PathVariable("candidateId") int candidateId, Model model) {
		voterService.recordVote(electionId, candidateId, getCurrentUSerEmail());
		return "redirect:/voter/electiondetails/" + electionId;
	}

	private String getCurrentUSerEmail() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		} else {
			return principal.toString();
		}
	}
}
