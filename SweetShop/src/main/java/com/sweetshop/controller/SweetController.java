package com.sweetshop.controller;

import com.sweetshop.model.Sweet;
import com.sweetshop.service.SweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sweets")
@CrossOrigin(origins = "http://localhost:4200") 
public class SweetController {

	@Autowired
	private SweetService service;

	@GetMapping
	public List<Sweet> list() {
		return service.list();
	}

	@GetMapping("/search")
	public List<Sweet> search(@RequestParam(required = false) String name,
			@RequestParam(required = false) String category, @RequestParam(required = false) Double min,
			@RequestParam(required = false) Double max) {
		if (name != null)
			return service.searchByName(name);
		if (category != null)
			return service.searchByCategory(category);
		if (min != null && max != null)
			return service.searchByPriceRange(min, max);
		return service.list();
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Sweet s, Authentication auth) {
		if (!hasAdmin(auth))
			return ResponseEntity.status(403).body("Admin only");
		return ResponseEntity.ok(service.create(s));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Sweet s, Authentication auth) {
		if (!hasAdmin(auth))
			return ResponseEntity.status(403).body("Admin only");
		return ResponseEntity.ok(service.update(id, s));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id, Authentication auth) {
		if (!hasAdmin(auth))
			return ResponseEntity.status(403).body("Admin only");
		service.delete(id);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/{id}/purchase")
	public ResponseEntity<?> purchase(@PathVariable Long id, @RequestParam(defaultValue = "1") int qty) {
		try {
			return ResponseEntity.ok(service.purchase(id, qty));
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}

	@PostMapping("/{id}/restock")
	public ResponseEntity<?> restock(@PathVariable Long id, @RequestParam(defaultValue = "1") int qty,
			Authentication auth) {
		if (!hasAdmin(auth))
			return ResponseEntity.status(403).body("Admin only");
		return ResponseEntity.ok(service.restock(id, qty));
	}

	private boolean hasAdmin(Authentication auth) {
		if (auth == null)
			return false;
		return auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
}
