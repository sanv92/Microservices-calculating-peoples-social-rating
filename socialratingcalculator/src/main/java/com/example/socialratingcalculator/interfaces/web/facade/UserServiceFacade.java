package com.example.socialratingcalculator.interfaces.web.facade;

import com.example.socialratingcalculator.application.UserService;
import com.example.socialratingcalculator.interfaces.web.facade.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceFacade {

	private ConversionService conversionService;

	private UserService userService;

	@Autowired
	public UserServiceFacade(ConversionService conversionService, UserService userService) {
		this.conversionService = conversionService;
		this.userService = userService;
	}

	public UserDto getUserByName(String firstName) {
		return conversionService.convert(
				userService.getUserByName(firstName),
				UserDto.class
		);
	}
}
