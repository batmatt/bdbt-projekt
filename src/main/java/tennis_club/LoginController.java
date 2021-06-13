package tennis_club;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/wylogowanie")
	public String logout() {
		return "login";
	}

	@RequestMapping("/login?error=true")
	public String retryLogin() {
		return "login";
	}
}