package in.ajaykumarsingh.evoting.controllers;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import in.ajaykumarsingh.evoting.models.Election;
import in.ajaykumarsingh.evoting.repositories.ElectionRepository;
import in.ajaykumarsingh.evoting.services.VoteCounterService;

@Controller
@RequestMapping({ "/home", "/" })
public class HomeController {

	@Autowired
	private ElectionRepository electionRepository;
	
	@Autowired
	private VoteCounterService voteCounterService;
	
	private static final Random RANDOM = new Random(System.currentTimeMillis());

	@GetMapping("")
	public String homePage() {
		return "home";
	}

	@GetMapping("/elections")
	public String elections(Model model) {
		Iterable<Election> elections = electionRepository.findAll();
		model.addAttribute("elections", elections);
		return "elections";
	}

	@GetMapping("/results/{electionId}")
	public String results(@PathVariable("electionId") int electionId, Model model) {
		Election election = electionRepository.findById(electionId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid election Id" + electionId));
		model.addAttribute("chartData", voteCounterService.getResults(electionId));
		model.addAttribute("election", election);
		return "results";
	}
	
}
