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
import in.ajaykumarsingh.evoting.models.Area;
import in.ajaykumarsingh.evoting.repositories.AreaRepository;

@Controller
@RequestMapping("/area")
@Secured("ADMIN")
public class AreaController {
	
	@Autowired
	private AreaRepository areaRepository;
	
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("areas", areaRepository.findAll());
		return "area/index";
	}
	
	@GetMapping("/add")
	public String addArea(Model model) {
		model.addAttribute("area", new Area());
		return "area/add";
	}
	
	@PostMapping("/add")
	public String addArea(Area area, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "area/add";
		}
		areaRepository.save(area);
		return "redirect:/area";
	}
	
	@GetMapping("/edit/{id}")
	public String showEdit(@PathVariable("id") int id, Model model) {
		
		Area area=areaRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Area Id"+id));
		model.addAttribute("area", area);
		
		return "area/edit";
	}
	
	@PostMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Area area, BindingResult result, Model model) {
		if(result.hasErrors()) {
			area.setId(id);
			return "area/edit";
		}
		areaRepository.save(area);
		return "redirect:/area";
	}
	
	@GetMapping("/delete/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		Area area=areaRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Area Id"+id));
		areaRepository.delete(area);
		return "redirect:/area";
	}
}
