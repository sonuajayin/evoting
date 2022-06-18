package in.ajaykumarsingh.evoting.controllers;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import in.ajaykumarsingh.evoting.models.User;
import in.ajaykumarsingh.evoting.repositories.AreaRepository;
import in.ajaykumarsingh.evoting.repositories.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AreaRepository areaRepository;
	
	@GetMapping("/register")
	public String registerUser(Model model) {
		model.addAttribute("areas", areaRepository.findAll());
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public String registerUser(User user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("areas", areaRepository.findAll());
			return "register";
		}
		user.setRole("USER");
		userRepository.save(user);
		return "redirect:/login";
	}
	
	@GetMapping("/redirect")
	public String postLoginRedirect() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Set<String> roles = authentication.getAuthorities().stream()
			     .map(r -> r.getAuthority()).collect(Collectors.toSet());
		
		if(roles.iterator().next().equals("ADMIN")) {
			return "redirect:/admin";
		}
		
		return "redirect:/voter";
	}
	
	@GetMapping("/admin/voters")
	@Secured("ADMIN")
	public String getVoters(Model model) {
		model.addAttribute("voters",userRepository.findAllByRole("USER"));
		return "admin/voters";
	}
}
