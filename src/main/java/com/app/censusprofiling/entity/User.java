package com.app.censusprofiling.entity;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class User {

	@Id
	@GeneratedValue
	//@Positive (message = "user_id should be greater than 0")
	private int userId;
	
	@Size(min = 1, max = 32,message="firstName length cannot be more than 32")
	@NotNull(message = "firstName is mandatory")
	private String firstName;
	
	@Size(min = 1, max = 32,message="lastName length cannot be more than 32")
	@NotNull(message = "lastName is mandatory")
	private String lastName;
	
	@NotNull(message = "DOB is mandatory")
	private LocalDate DOB;
	
	@NotNull(message = "contactNo is mandatory")
	private String contactNo;
	
	// OneToOne unidirectional relationship 
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "email")
	private Login login;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "applicationId", referencedColumnName = "id")
	private Application application_entity;
	
	@OneToMany(targetEntity = Member.class, cascade = CascadeType.ALL)
	@JoinColumn(name="userId",referencedColumnName="userId")
	private List<Member> member_list;	
	
public User(int i, String string, String string2, LocalDate parse, String string3, String string4, String string5) {
		
	}
}