package tennis_club;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("placowki")
public class PlacowkiController {

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

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("placowka") Placowka placowka) {
		dao.save(placowka);

		return "redirect:/placowki/";
	}

	@RequestMapping("/edit/{idPlacowki}")
	public ModelAndView showEditForm(@PathVariable(name = "idPlacowki") int idPlacowki) {
		ModelAndView mav = new ModelAndView("edit_outpost");
		Placowka placowka = dao.get(idPlacowki);
		mav.addObject("placowka", placowka);

		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("placowka") Placowka placowka) {
		dao.update(placowka);

		return "redirect:/placowki/";
	}

	@RequestMapping("/delete/{idPlacowki}")
	public String delete(@PathVariable(name = "idPlacowki") int idPlacowki) {
		dao.delete(idPlacowki);

		return "redirect:/placowki/";
	}
}
