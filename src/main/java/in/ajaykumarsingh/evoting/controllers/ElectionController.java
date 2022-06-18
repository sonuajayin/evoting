package in.ajaykumarsingh.evoting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import in.ajaykumarsingh.evoting.models.Candidate;
import in.ajaykumarsingh.evoting.models.Election;
import in.ajaykumarsingh.evoting.repositories.AreaRepository;
import in.ajaykumarsingh.evoting.repositories.CandidateRepository;
import in.ajaykumarsingh.evoting.repositories.ElectionRepository;

@Controller
@RequestMapping("/election")
@Secured("ADMIN")
public class ElectionController {
	
	@Autowired
	private AreaRepository areaRepository;
	
	@Autowired
	private ElectionRepository electionRepository;
	
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("elections", electionRepository.findAll());
		return "election/index";
	}
	
	@GetMapping("/add")
	public String addElection(Model model) {
		model.addAttribute("areas", areaRepository.findAll());
		model.addAttribute("election", new Election());		
		return "election/add";
	}
	
	@PostMapping("/add")
	public String addElection(Election election, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("areas", areaRepository.findAll());
			return "election/add";
		}
		electionRepository.save(election);
		return "redirect:/election";
	}
	
	@GetMapping("/edit/{id}")
	public String showEdit(@PathVariable("id") int id, Model model) {
		
		Election election=electionRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid election Id"+id));
		model.addAttribute("areas", areaRepository.findAll());
		model.addAttribute("election", election);		
		return "election/edit";
	}
	
	@PostMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Election election, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("areas", areaRepository.findAll());
			election.setId(id);
			return "election/edit";
		}
		electionRepository.save(election);
		return "redirect:/election";
	}
	
	@GetMapping("/delete/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		Election election=electionRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid election Id"+id));
		electionRepository.delete(election);
		return "redirect:/election";
	}
}
