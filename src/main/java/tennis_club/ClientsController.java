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
@RequestMapping("klienci")
public class ClientsController {

	@Autowired
	private ClientsDAO dao;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Client> clients = dao.list();
		model.addAttribute("clients", clients);

		return "index_client";

	}

	@RequestMapping("/new")
	public String showNewForm(Model model) {
		Client client = new Client();
		model.addAttribute("client", client);

		return "new_client";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("client") Client client) {
		dao.save(client);

		return "redirect:/";
	}

	@RequestMapping("/edit/{idKlienta}")
	public ModelAndView showEditForm(@PathVariable(name = "idKlienta") int idKlienta) {
		ModelAndView mav = new ModelAndView("edit_client");
		Client client = dao.get(idKlienta);
		mav.addObject("client", client);

		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("klient") Client client) {
		dao.update(client);

		return "redirect:/";
	}

	@RequestMapping("/delete/{idKlienta}")
	public String delete(@PathVariable(name = "idKlienta") int idKlienta) {
		dao.delete(idKlienta);

		return "redirect:/";
	}
}
