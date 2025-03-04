package com.cybaemtech.controller;

import com.cybaemtech.model.User;
import com.cybaemtech.service.UserService;
import com.cybaemtech.validation.ValidationProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController
{
	private final UserService userService;

	@Autowired
	public UserController(final UserService userService)
	{
		this.userService = userService;
	}

	@GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public final List<User> getAllUsers()
	{
		return userService.getAllUsers();
	}

	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public final ResponseEntity<User> getUserById(final @PathVariable Long id)
	{
		final User user = userService.getUserById(id);

		if (user != null)
		{
			return ResponseEntity.ok(user);
		}
		else
		{
			return ResponseEntity.badRequest().build();
		}
	}

	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public final ResponseEntity<User> createUser(final @Valid @RequestBody User user, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors())
		{
			ValidationProcessor.processValidationErrors(bindingResult);
		}

		final User savedUser = userService.createUser(user);

		return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	}

	@PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public final ResponseEntity<User> updateUser(final @PathVariable Long id, @Valid @RequestBody User user, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors())
		{
			ValidationProcessor.processValidationErrors(bindingResult);
		}

		final User updatedUser = userService.updateUser(id, user);

		if (updatedUser != null)
		{
			return ResponseEntity.ok(updatedUser);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public final ResponseEntity<Void> deleteUser(final @PathVariable Long id)
	{
		userService.deleteUser(id);

		return ResponseEntity.noContent().build();
	}
}
