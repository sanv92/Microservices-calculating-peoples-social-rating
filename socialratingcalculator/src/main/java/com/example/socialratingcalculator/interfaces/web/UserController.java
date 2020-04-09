package com.example.socialratingcalculator.interfaces.web;

import com.example.socialratingcalculator.interfaces.web.facade.UserServiceFacade;
import com.example.socialratingcalculator.interfaces.web.facade.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

	private UserServiceFacade userService;

	@Autowired
	public UserController(UserServiceFacade userService) {
		this.userService = userService;
	}

	@GetMapping("/{firstName}")
	public UserDto messageSend(@PathVariable("firstName") String firstName) {
		return userService.getUserByName(firstName);
	}
}