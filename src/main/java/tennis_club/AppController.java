package tennis_club;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	
	@Autowired
	private ClientsDAO clientsDAO;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Client> clients = clientsDAO.list();
		model.addAttribute("clients", clients);
		
		return "index";
		 
	}

}
