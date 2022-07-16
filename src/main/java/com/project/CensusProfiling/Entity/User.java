package com.project.CensusProfiling.Entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="user_data")
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Size(min = 1, max = 32,message="firstName length cannot be more than 32")
	@NotNull(message = "firstName is mandatory")
	private String firstName;
	
	@Size(min = 1, max = 32,message="lastName length cannot be more than 32")
	@NotNull(message = "lastName is mandatory")
	private String lastName;
	
	@NotNull(message = "DOB is mandatory")
	private LocalDate DOB;
	
	@Email(message = "Email is invalid")
	@NotNull(message = "Email is mandatory")
	private String email;
	
	@NotNull(message = "contactNo is mandatory")
	private String contactNo;
	
	@NotNull(message = "password is mandatory")
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "applicationId", referencedColumnName = "id")
	private Application application_entity;
	
	@OneToMany(targetEntity = Member.class, cascade = CascadeType.ALL)
	@JoinColumn(name="user_fk",referencedColumnName="id")
	private List<Member> member_list;	
	
	public User() {
		super();
	}

	

	public User(@Min(1) int id,
			@Size(min = 1, max = 32, message = "firstName length cannot be more than 32") @NotNull(message = "firstName is mandatory") String firstName,
			@Size(min = 1, max = 32, message = "lastName length cannot be more than 32") @NotNull(message = "lastName is mandatory") String lastName,
			@NotNull(message = "DOB is mandatory") LocalDate dOB,
			@Email(message = "Email is invalid") @NotNull(message = "Email is mandatory") String email,
			@NotNull(message = "contactNo is mandatory") String contactNo,
			@NotNull(message = "password is mandatory") String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		DOB = dOB;
		this.email = email;
		this.contactNo = contactNo;
		this.password = password;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public List<Member> getMember_list() {
		return member_list;
	}

	public void setMember_list(List<Member> member_list) {
		this.member_list = member_list;
	}

	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}


	public Application getApplication_entity() {
		return application_entity;
	}


	public void setApplication_entity(Application application_entity) {
		this.application_entity = application_entity;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
}
