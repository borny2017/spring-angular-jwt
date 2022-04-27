package de.test.springjwt.models;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Data
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username", unique = true, nullable = false, length = 20)
	private String username;

	@Column(name = "email", unique = true, nullable = false, length = 20)
	private String email;

	@Column(name = "password", unique = false, nullable = false, length = 20)
	private String password;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public User() {
	}

	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
}
