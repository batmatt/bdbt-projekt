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
@RequestMapping("adresy")
public class AdresyController {

	@Autowired
	private AdresyDAO dao;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Adres> adresy = dao.list();
		model.addAttribute("adresy", adresy);

		return "index_address";
	}

	@RequestMapping("/new")
	public String showNewForm(Model model) {
		Adres adres = new Adres();
		model.addAttribute("adres", adres);

		return "new_address";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("adres") Adres adres) {
		dao.save(adres);

		return "redirect:/";
	}

	@RequestMapping("/edit/{idAdresu}")
	public ModelAndView showEditForm(@PathVariable(name = "idAdresu") int idAdresu) {
		ModelAndView mav = new ModelAndView("edit_address");
		Adres adres = dao.get(idAdresu);
		mav.addObject("adres", adres);

		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("adres") Adres adres) {
		dao.update(adres);

		return "redirect:/";
	}

	@RequestMapping("/delete/{idAdresu}")
	public String delete(@PathVariable(name = "idAdresu") int idAdresu) {
		dao.delete(idAdresu);

		return "redirect:/";
	}
}
