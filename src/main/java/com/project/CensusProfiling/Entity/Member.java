package com.project.CensusProfiling.Entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;


@Entity
@Table(name="member_data")
public class Member {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Size(min = 1, max = 32,message="firstName length cannot be more than 32")
	@NotNull(message = "firstName is mandatory")
	@Column(name="firstName")
	private String firstName;
	
	@Size(min = 1, max = 32,message="lastName length cannot be more than 32")
	@NotNull(message = "lastName is mandatory")
	@Column(name="lastName")
	private String lastName;
	
	@Past
	@NotNull(message = "DOB is mandatory")
	@Column(name="DOB")
	private LocalDate DOB;
	
	@NotNull(message = "gender is mandatory")
	@Column(name="gender")
	private String gender;
	
	@NotNull(message = "relationShip is mandatory")
	@Column(name="relationShip")
	private String relationShip;

	@NotNull(message = "qualification is mandatory")
	@Column(name="qualification")
	private String qualification;

	@NotNull(message = "marital_status is mandatory")
	@Column(name="marital_status")
	private String marital_status;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;
	
	public Member() {
		super();
	}

	
	public Member(@Min(1) int id,
			@Size(min = 1, max = 32, message = "firstName length cannot be more than 32") @NotNull(message = "firstName is mandatory") String firstName,
			@Size(min = 1, max = 32, message = "lastName length cannot be more than 32") @NotNull(message = "lastName is mandatory") String lastName,
			@Past @NotNull(message = "DOB is mandatory") LocalDate dOB,
			@NotNull(message = "gender is mandatory") String gender,
			@NotNull(message = "relationShip is mandatory") String relationShip,
			@NotNull(message = "qualification is mandatory") String qualification,
			@NotNull(message = "marital_status is mandatory") String marital_status, Address address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		DOB = dOB;
		this.gender = gender;
		this.relationShip = relationShip;
		this.qualification = qualification;
		this.marital_status = marital_status;
		this.address = address;
	}


	public Member(int i, String string, String string2, LocalDate localDate, String string3, String string4,
			String string5, String string6) {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRelationShip() {
		return relationShip;
	}

	public void setRelationShip(String relationShip) {
		this.relationShip = relationShip;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getMarital_status() {
		return marital_status;
	}

	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}

	public Address getAddressEntity() {
		return address;
	}

	public void setAddressEntity(Address address) {
		this.address = address;
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


	@Override
	public String toString() {
		return "MemberEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", DOB=" + DOB
				+ ", gender=" + gender + ", relationShip=" + relationShip + ", qualification="
				+ qualification + ", marital_status=" + marital_status + ", addressEntity=" + address + "]";
	}
	
}
