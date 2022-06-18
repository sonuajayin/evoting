package in.ajaykumarsingh.evoting.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({ "/home", "/" })
public class HomeController {

	@GetMapping("")
	public ModelAndView homePage() {
		return new ModelAndView("home");
	}
	
	@GetMapping("/results")
	public ModelAndView results() {
		return new ModelAndView("results");
	}
}
