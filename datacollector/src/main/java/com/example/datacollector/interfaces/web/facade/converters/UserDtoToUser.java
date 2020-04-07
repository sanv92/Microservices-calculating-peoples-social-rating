package com.example.datacollector.interfaces.web.facade.converters;

import com.example.datacollector.domain.model.User;
import com.example.datacollector.interfaces.web.facade.dto.UserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUser implements Converter<UserDto, User> {

	@Override
	public User convert(UserDto userDto) {
		return new User(
				userDto.getFirstName(),
				userDto.getLastName(),
				userDto.getBirthdayDateTime()
		);
	}
}
