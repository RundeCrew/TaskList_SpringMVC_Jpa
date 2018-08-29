package co.grandcircus.TaskList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.grandcircus.TaskList.dao.TaskDao;
import co.grandcircus.TaskList.dao.UserDao;
import co.grandcircus.TaskList.entity.Task;
import co.grandcircus.TaskList.entity.User;


@Controller
public class UserController {
	
	@Autowired
	UserDao userDao;
	@Autowired
	TaskDao taskDao;

	@RequestMapping("/tasks")
	public ModelAndView index(@SessionAttribute(name="user", required=false) User user, RedirectAttributes redir) {
		// For this URL, make sure there is a user on the session.
		if (user == null) {
			// if not, send them back to the login page with a message.
			redir.addFlashAttribute("message", "Wait! Please log in.");
			return new ModelAndView("redirect:/login");
		}

		ModelAndView mav = new ModelAndView("tasks");
		mav.addObject("tasks", taskDao.findAll());
		return mav;
	}
	
	@RequestMapping("/add-task")
	public ModelAndView addNewTask(@SessionAttribute(name="user", required=false) User user, RedirectAttributes redir) {
		if (user == null) {
			redir.addFlashAttribute("message", "Wait! Please log in.");
			return new ModelAndView("redirect:/login");
		}
		return new ModelAndView("add-task");
	}
	
	@PostMapping("/add-task")
	public ModelAndView submitAddTask(Task task) {
		task.setDescription(task.getDescription());
		task.setDueDate(task.getDueDate());
		task.setUser(task.getUser());
		task.setComplete(task.getComplete());
		taskDao.save(task);
		ModelAndView mav = new ModelAndView("redirect:/tasks");
		return mav;
	}
	
	@PostMapping("/tasks")
	public ModelAndView showTasks() {
		List<Task> tasks = taskDao.findAll();
		return new ModelAndView("tasks", "tasks", tasks);
	}
}

