package in.ineuron.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ineuron.model.User;
import in.ineuron.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/get")
	public String getUserById(Map<String, Object> model, @RequestParam Integer userId) {

		User user = service.findUserById(userId);
		model.put("retrivedUser", user);
		return "success"; // will be executed if no Exception raised
	}
}
