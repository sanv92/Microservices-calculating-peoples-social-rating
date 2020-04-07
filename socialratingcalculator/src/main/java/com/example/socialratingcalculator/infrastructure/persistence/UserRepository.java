package com.example.socialratingcalculator.infrastructure.persistence;

import com.example.socialratingcalculator.domain.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String> {
	List<User> findByFirstName(String firstName);
}
