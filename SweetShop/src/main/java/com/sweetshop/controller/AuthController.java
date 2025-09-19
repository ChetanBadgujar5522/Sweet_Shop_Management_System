package com.sweetshop.controller;

import com.sweetshop.dto.AuthRequest;
import com.sweetshop.dto.AuthResponse;
import com.sweetshop.model.User;
import com.sweetshop.repository.UserRepository;
import com.sweetshop.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody AuthRequest request) {
		if (userRepository.existsByUsername(request.getUsername())) {
			return ResponseEntity.badRequest().body("Username already exists");
		}
		User u = new User();
		u.setUsername(request.getUsername());
		u.setPassword(passwordEncoder.encode(request.getPassword()));
		u.setRole("ROLE_USER");
		userRepository.save(u);

		String token = jwtUtil.generateToken(u.getUsername(), u.getRole());
		return ResponseEntity.ok(new AuthResponse(token));
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthRequest request) {
		return userRepository.findByUsername(request.getUsername()).map(u -> {
			if (passwordEncoder.matches(request.getPassword(), u.getPassword())) {
				String token = jwtUtil.generateToken(u.getUsername(), u.getRole());
				return ResponseEntity.ok(new AuthResponse(token));
			} else {
				return ResponseEntity.status(401).body("Invalid credentials");
			}
		}).orElse(ResponseEntity.status(401).body("Invalid credentials"));
	}
}