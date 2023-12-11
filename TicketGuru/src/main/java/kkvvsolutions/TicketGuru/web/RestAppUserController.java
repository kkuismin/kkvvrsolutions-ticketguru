package kkvvsolutions.TicketGuru.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kkvvsolutions.TicketGuru.domain.AppUser;
import kkvvsolutions.TicketGuru.domain.repository.AppUserRepository;

@RestController
@RequestMapping("/api")
public class RestAppUserController {

	@Autowired
	private AppUserRepository userRepository;

	// Endpoint to get all AppUsers
	@GetMapping("/users")
	public ResponseEntity<List<AppUser>> getAllAppUsers() {
		try {
			List<AppUser> users = new ArrayList<>();
			userRepository.findAll().forEach(users::add);
			if (users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// Endpoint to get a single AppUser by ID
	@GetMapping("/users/{id}")
	public ResponseEntity<AppUser> getAppUserById(@PathVariable("id") Long user_id) {
		Optional<AppUser> userData = userRepository.findById(user_id);
		if (userData.isPresent()) {
			return new ResponseEntity<>(userData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Endpoint to create a new AppUser
	@PostMapping("/users")
	public ResponseEntity<AppUser> createAppUser(@Valid @RequestBody AppUser user) {
		if (!isValidRole(user.getRole())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		try {
			AppUser _user = userRepository
					.save(new AppUser(user.getUsername(), user.getPasswordHash(), user.getRole()));
			return new ResponseEntity<>(_user, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	// Endpoint to update an existing AppUser
	@PutMapping("users/{id}")
	public ResponseEntity<AppUser> updateAppUser(@PathVariable("id") Long user_id, @Valid @RequestBody AppUser user) {
		if (!isValidRole(user.getRole())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<AppUser> userData = userRepository.findById(user_id);
		if (userData.isPresent()) {
			AppUser _user = userData.get();
			_user.setUsername(user.getUsername());
			_user.setPasswordHash(user.getPasswordHash());
			_user.setRole(user.getRole());

			return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Endpoint to delete an AppUser by ID
	@DeleteMapping("/users/{id}")
	public ResponseEntity<HttpStatus> deleteAppUser(@PathVariable("id") Long user_id) {
		try {
			userRepository.deleteById(user_id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Helper method to validate user roles
	private boolean isValidRole(String role) {
		return "ADMIN".equals(role) || "TICKETSELLER".equals(role);
	}
}