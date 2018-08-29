package co.grandcircus.TaskList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.grandcircus.TaskList.dao.TaskDao;
import co.grandcircus.TaskList.dao.UserDao;
import co.grandcircus.TaskList.entity.User;

@Controller
public class AuthController {

	
	@Autowired
	UserDao userDao;
	@Autowired
	TaskDao taskDao;

	@RequestMapping("/login")
	public ModelAndView showLoginForm() {
		return new ModelAndView("login");
	}

	@PostMapping("/login")
	// get the username and password from the form when it's submitted.
	public ModelAndView submitLoginForm(
			@RequestParam("email") String email,
			@RequestParam("name") String name, 
			@RequestParam("password") String password,
			HttpSession session) {
		 
		User user = userDao.findByEmail(email);
		if (user != null && password.equals(user.getPassword())) {
			session.setAttribute("user", user); // if they do match
			
			return new ModelAndView("redirect:/");
		}else {
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("message", "Incorrect username or password.");
			return mav;
		}
		
		
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session, RedirectAttributes redir) {
		
		session.invalidate();
		redir.addFlashAttribute("message", "Logged Out");
		return new ModelAndView("redirect:/");
	}
}
