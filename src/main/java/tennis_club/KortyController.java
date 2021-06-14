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
@RequestMapping("korty")
public class KortyController {

	@Autowired
	private KortyDAO dao;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Kort> korty = dao.list();
		model.addAttribute("korty", korty);

		return "index_court";
	}

	@RequestMapping("/new")
	public String showNewForm(Model model) {
		Kort kort = new Kort();
		model.addAttribute("kort", kort);

		return "new_court";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("kort") Kort kort) {
		dao.save(kort);

		return "redirect:/korty/";
	}

	@RequestMapping("/edit/{idKortu}")
	public ModelAndView showEditForm(@PathVariable(name = "idKortu") int idKortu) {
		ModelAndView mav = new ModelAndView("edit_court");
		Kort kort = dao.get(idKortu);
		mav.addObject("kort", kort);

		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("kort") Kort kort) {
		dao.update(kort);

		return "redirect:/korty/";
	}

	@RequestMapping("/delete/{idKortu}")
	public String delete(@PathVariable(name = "idKortu") int idKortu) {
		dao.delete(idKortu);

		return "redirect:/korty/";
	}
}
