package com.project.CensusProfiling.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
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
	
	public Address() {
		super();
	}

	public Address(@Min(1) int id, @NotNull(message = "d_no is mandatory") String d_no,
			@NotNull(message = "street is mandatory") String street,
			@NotNull(message = "city is mandatory") String city, @NotNull(message = "state is mandatory") String state,
			@Size(min = 6, max = 6, message = "pincode should be of size 6") @NotNull(message = "pincode is mandatory") String pincode) {
		super();
		this.id = id;
		this.d_no = d_no;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getD_no() {
		return d_no;
	}

	public void setD_no(String d_no) {
		this.d_no = d_no;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "AddressEntity [id=" + id + ", d_no=" + d_no + ", street=" + street + ", city=" + city + ", state="
				+ state + ", pincode=" + pincode + "]";
	} 
	
	
	
	
}
