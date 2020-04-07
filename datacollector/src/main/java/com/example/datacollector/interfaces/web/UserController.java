package com.example.datacollector.interfaces.web;

import com.example.datacollector.interfaces.web.facade.UserSenderServiceFacade;
import com.example.datacollector.interfaces.web.facade.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserSenderServiceFacade userSenderServiceFacade;

	@Autowired
	public UserController(UserSenderServiceFacade userSenderServiceFacade) {
		this.userSenderServiceFacade = userSenderServiceFacade;
	}

	@PostMapping("/message")
	public void messageSend(@Valid @RequestBody UserDto userDto) {
		userSenderServiceFacade.sender(userDto);
	}
}