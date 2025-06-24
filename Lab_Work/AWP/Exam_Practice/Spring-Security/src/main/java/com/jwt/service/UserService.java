package com.jwt.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt.dto.UserDTO;
import com.jwt.entity.User;
import com.jwt.repository.RoleRepository;
import com.jwt.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    

    public User createUser(UserDTO userDTO) throws Exception {
        // Check if email already exists
        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            throw new Exception("Email already exists");
        }

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setActive(true);
        user.setRole(roleRepository.findByName("USER")
            .orElseThrow(() -> new Exception("Default role not found")));
        user.setRoleExpiryDate(LocalDate.now().plusMonths(6));

        return userRepository.save(user);
    }

    // Read user by ID
    public User getUserById(Long id) throws Exception {
        return userRepository.findById(id).orElseThrow(() -> new Exception("User not found"));
    }

    // Update user information
    public User updateUser(Long id, UserDTO userDTO) throws Exception {
        User user = getUserById(id);
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return userRepository.save(user);
    }

    // Delete user by ID
    public void deleteUser(Long id) throws Exception {
        User user = getUserById(id);
        userRepository.delete(user);
    }

    // Get all users (for admin management)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

 // Get user by email (for login)
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
 
    
    

}
