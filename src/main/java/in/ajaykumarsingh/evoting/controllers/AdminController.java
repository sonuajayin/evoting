package in.ajaykumarsingh.evoting.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@Secured("ADMIN")
public class AdminController {

	@GetMapping("")
	public String index() {
		return "admin/index";
	}
}
