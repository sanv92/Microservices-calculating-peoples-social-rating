package com.example.socialratingcalculator.interfaces.web;

import com.example.socialratingcalculator.application.UserService;
import com.example.socialratingcalculator.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/{firstName}")
	public User messageSend(@PathVariable("firstName") String firstName) {
		return userService.getUserByName(firstName);
	}
}