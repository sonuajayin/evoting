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
import in.ajaykumarsingh.evoting.repositories.AreaRepository;
import in.ajaykumarsingh.evoting.repositories.CandidateRepository;

@Controller
@RequestMapping("/candidate")
@Secured("ADMIN")
public class CandidateController {
	
	@Autowired
	private AreaRepository areaRepository;
	
	@Autowired
	private CandidateRepository candidateRepository;
	
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("candidates", candidateRepository.findAll());
		return "candidate/index";
	}
	
	@GetMapping("/add")
	public String addCandidate(Model model) {
		model.addAttribute("areas", areaRepository.findAll());
		model.addAttribute("candidate", new Candidate());		
		return "candidate/add";
	}
	
	@PostMapping("/add")
	public String addCandidate(Candidate candidate, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "candidate/add";
		}
		candidateRepository.save(candidate);
		return "redirect:/candidate";
	}
	
	@GetMapping("/edit/{id}")
	public String showEdit(@PathVariable("id") int id, Model model) {
		
		Candidate candidate=candidateRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid candidate Id"+id));
		model.addAttribute("candidate", candidate);
		
		return "candidate/edit";
	}
	
	@PostMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Candidate candidate, BindingResult result, Model model) {
		if(result.hasErrors()) {
			candidate.setId(id);
			return "candidate/edit";
		}
		candidateRepository.save(candidate);
		return "redirect:/candidate";
	}
	
	@GetMapping("/delete/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		Candidate candidate=candidateRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid candidate Id"+id));
		candidateRepository.delete(candidate);
		return "redirect:/candidate";
	}
}
