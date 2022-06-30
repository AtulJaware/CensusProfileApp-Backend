package com.project.CensusProfiling.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="login_data")
public class LoginEntity {
	
	@Id
	@Email(message="email is not valid")
	@NotNull(message = "email is mandatory")
	private String email;
	
	@Size(min = 5, max = 32,message="password length should be with 5 to 32 range")
	@NotNull(message = "password is mandatory")
	private String password;

	@NotNull(message = "role is mandatory")
	private String role;

	public LoginEntity() {
		super();
	}

	public LoginEntity(@Email(message = "email is not valid") @NotNull(message = "email is mandatory") String email,
			@Size(min = 5, max = 32, message = "password length should be with 5 to 32 range") @NotNull(message = "password is mandatory") String password,
			@NotNull(message = "role is mandatory") String role) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "LoginEntity [email=" + email + ", password=" + password + ", role=" + role + "]";
	}
	
	
}
