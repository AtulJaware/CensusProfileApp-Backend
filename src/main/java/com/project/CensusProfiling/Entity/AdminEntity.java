package com.project.CensusProfiling.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="admin_data")
public class AdminEntity {
	
	@Id
	@Email(message="email is not valid")
	@NotNull(message = "email is mandatory")
	private String email;
	
	@NotNull(message = "name is mandatory")
	private String name;
	
	@NotNull(message = "contact is mandatory")
	private String contact;
	
	@Size(min = 5, max = 32,message="password length should be with 5 to 32 range")
	@NotNull(message = "password is mandatory")
	private String password;

	public AdminEntity() {
		super();
	}

	

	public AdminEntity(@Email(message = "email is not valid") @NotNull(message = "email is mandatory") String email,
			@NotNull(message = "name is mandatory") String name,
			@NotNull(message = "contact is mandatory") String contact,
			@Size(min = 5, max = 32, message = "password length should be with 5 to 32 range") @NotNull(message = "password is mandatory") String password) {
		super();
		this.email = email;
		this.name = name;
		this.contact = contact;
		this.password = password;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}



	@Override
	public String toString() {
		return "AdminEntity [email=" + email + ", name=" + name + ", contact=" + contact + ", password=" + password
				+ "]";
	}

	
	

}
