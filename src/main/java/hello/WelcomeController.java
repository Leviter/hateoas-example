package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

	@RequestMapping("/welcome")
	public String greeting(
			@RequestParam(value = "name", required = false, defaultValue = "Controller") String name, Model model) {
		model.addAttribute("name", name);
		return "welcome";
	}

	@RequestMapping("/welcome10")
	public String greeting10(
			@RequestParam(value = "name", required = false, defaultValue = "Controller") String name, Model model) {
		model.addAttribute("name", name);
		return "welcome10";
	}

	@RequestMapping("/welcome11")
	public String greeting11(
			@RequestParam(value = "name", required = false, defaultValue = "Controller") String name, Model model) {
		model.addAttribute("name", name);
		return "welcome11";
	}

	@RequestMapping("/welcome20")
	public String greeting20(
			@RequestParam(value = "name", required = false, defaultValue = "Controller") String name, Model model) {
		model.addAttribute("name", name);
		return "welcome20";
	}

}