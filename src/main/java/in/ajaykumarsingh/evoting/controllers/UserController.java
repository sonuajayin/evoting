package in.ajaykumarsingh.evoting.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import in.ajaykumarsingh.evoting.models.User;

@Controller
public class UserController {
	
	@GetMapping("/register")
	public ModelAndView registerUser() {
		
		return new ModelAndView("register");
	}

	@PostMapping("/register")
	public ModelAndView registerUser(User model) {
		
		return new ModelAndView();
	}
}
