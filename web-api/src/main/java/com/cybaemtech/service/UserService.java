package com.cybaemtech.service;

import com.cybaemtech.model.User;
import com.cybaemtech.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserService
{
	private static final Logger logger = LogManager.getLogger(UserService.class);

	private final UserRepository userRepository;

	@Autowired
	public UserService(final UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}

	@Transactional(readOnly = true)
	public List<User> getAllUsers()
	{
		logger.info("Fetching all users");

		return userRepository.findAll();
	}

	@Transactional(readOnly = true)
	public User getUserById(final Long id)
	{
		logger.info("Fetching user by id: {}", id);

		return userRepository.findById(id).orElse(null);

	}

	@Transactional
	public User createUser(final User user)
	{
		logger.info("Creating user: {}", user);

		return userRepository.save(user);
	}

	@Transactional
	public User updateUser(final Long id, User user)
	{
		logger.info("Updating user with id {}: {}", id, user);

		final User existingUser = userRepository.findById(id).orElse(null);

		if (existingUser != null)
		{
			existingUser.setUsername(user.getUsername());
			existingUser.setEmail(user.getEmail());
			existingUser.setCity(user.getCity());

			return userRepository.save(existingUser);
		}
		return null;
	}

	@Transactional
	public void deleteUser(final Long id)
	{
		logger.info("Deleting user with id: {}", id);

		userRepository.deleteById(id);
	}
}
