package tennis_club;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

	@Autowired
	private PlacowkiDAO dao;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Placowka> placowki = dao.list();
		model.addAttribute("placowki", placowki);

		return "index_outpost";

	}

	@RequestMapping("/new")
	public String showNewForm(Model model) {
		Placowka placowka = new Placowka();
		model.addAttribute("placowka", placowka);

		return "new_outpost";

	}

}
