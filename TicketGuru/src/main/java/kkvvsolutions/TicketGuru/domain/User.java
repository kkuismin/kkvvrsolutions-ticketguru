package kkvvsolutions.TicketGuru.domain;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId", nullable = false, updatable = false)
	private Long userId;
	
	@NotNull(message = "Username cannot be null")
	@Size(min = 1, max = 20)
	@Column(name = "username", nullable = false)
	private String username;
	
	@NotNull(message = "Password cannot be null")
	@Size(min = 1, max = 20)
	@Column(name = "password", nullable = false)
	private String password;
	
	@NotNull(message = "Role cannot be null")
	@Size(min = 1, max = 20)
	@Column(name = "role", nullable = false)
	private String role;

	@Transient
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public User() {
		super();
	}

	public User(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = passwordEncoder.encode(password);
	}
	
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", role=" + role + "]";
	}
}

	