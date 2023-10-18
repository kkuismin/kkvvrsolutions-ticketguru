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
import kkvvsolutions.TicketGuru.domain.User;
import kkvvsolutions.TicketGuru.domain.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class RestUserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		try {
			List<User> users = new ArrayList<>();
			userRepository.findAll().forEach(users::add);
			if(users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long user_id) {
		Optional<User> userData = userRepository.findById(user_id);
		if(userData.isPresent()) {
			return new ResponseEntity<>(userData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		try {
			User _user = userRepository
					.save(new User(user.getUsername(), user.getPassword(), user.getRole()));
			return new ResponseEntity<>(_user, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Long user_id, @Valid @RequestBody User user) {
		Optional<User> userData = userRepository.findById(user_id);
		if(userData.isPresent()) {
			User _user = userData.get();
			_user.setUsername(user.getUsername());
			_user.setPassword(user.getPassword());
			_user.setRole(user.getRole());
			
			return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long user_id) {
		try {
			userRepository.deleteById(user_id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}