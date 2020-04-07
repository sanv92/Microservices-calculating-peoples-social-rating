package com.example.datacollector.interfaces.web.facade;

import com.example.datacollector.domain.model.User;
import com.example.datacollector.infrastructure.messaging.UserSenderService;
import com.example.datacollector.interfaces.web.facade.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserSenderServiceFacade {

	private ConversionService conversionService;

	private UserSenderService userSenderService;

	@Autowired
	public UserSenderServiceFacade(ConversionService conversionService, UserSenderService userSenderService) {
		this.conversionService = conversionService;
		this.userSenderService = userSenderService;
	}

	public void sender(UserDto userDto) {
		log.info("User sender, dto request -> {}", userDto);
		final var user = conversionService.convert(userDto, User.class);
		userSenderService.sender(user);
		log.info("User sender, produced user -> {}", user);
	}
}
