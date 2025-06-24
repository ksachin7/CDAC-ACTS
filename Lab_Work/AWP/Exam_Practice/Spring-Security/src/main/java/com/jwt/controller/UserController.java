package com.jwt.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.dto.UserDTO;
import com.jwt.entity.User;
import com.jwt.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {

	
	
	@Autowired
	private UserService userService;

		// Create a new user
	@PostMapping("/register")
	public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) throws Exception {
		try {
			userService.createUser(userDTO);
			return new ResponseEntity<>("User created successfully!", HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	
	// Get user by ID
	@GetMapping("/getUserById/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) throws Exception {
		try {
			User user = userService.getUserById(id);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	// Update user information
	@PutMapping("/updateUserById/{id}")
	public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) throws Exception {
		try {
			userService.updateUser(id, userDTO);
			return new ResponseEntity<>("User updated successfully!", HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	// Delete user by ID
	@DeleteMapping("/deleteUserById/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) throws Exception {
		try {
			userService.deleteUser(id);
			return new ResponseEntity<>("User deleted successfully!", HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	// Get all users (for admin management)
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@GetMapping("/email/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
		Optional<User> user = userService.getUserByEmail(email);

		if (user.isPresent()) {
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}

