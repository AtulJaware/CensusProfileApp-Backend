package com.app.censusprofiling.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="member")
public class Member {

	@Id
	@SequenceGenerator(name="ADD_SEQ_GEN", sequenceName="ADD_SEQ_GEN", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ADD_SEQ_GEN")
	@Column(name="memId")
	private int memId;
	
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
    @JoinColumn(name = "addressId", referencedColumnName = "id")
	private Address address;
	
	
	public Member(int i, String string, String string2, LocalDate localDate, String string3, String string4,
			String string5, String string6) {
	}
}
