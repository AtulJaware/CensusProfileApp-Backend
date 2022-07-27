package com.app.censusprofiling.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="address")
public class Address {

	@Id
	@SequenceGenerator(name="ADD_SEQ_GEN", sequenceName="ADD_SEQ_GEN", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ADD_SEQ_GEN")
	@Column(name="id")
	private int id;
	
	@NotNull(message = "d_no is mandatory")
	@Column(name="d_no")
	private String d_no;

	@NotNull(message = "street is mandatory")
	@Column(name="street")
	private String street;

	@NotNull(message = "city is mandatory")
	@Column(name="city")
	private String city;
	
	@NotNull(message = "state is mandatory")
	@Column(name="state")
	private String state; 	
	
	@Size(min = 6, max = 6, message ="pincode should be of size 6")
	@NotNull(message = "pincode is mandatory")
	@Column(name="pincode")
	private String pincode;
	
}