package com.example.datacollector.interfaces.web.facade.converters;

import com.example.datacollector.domain.model.User;
import com.example.datacollector.interfaces.web.facade.dto.UserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDto implements Converter<User, UserDto> {

	@Override
	public UserDto convert(User user) {
		return UserDto.builder()
				.id(user.getId())
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.birthdayDateTime(user.getBirthdayDateTime())
				.build();
	}
}
