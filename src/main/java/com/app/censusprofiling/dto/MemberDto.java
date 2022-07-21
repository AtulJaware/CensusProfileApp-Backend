package com.app.censusprofiling.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MemberDto {

	private String firstName;
	private String lastName;
	private LocalDate DOB;
	private String gender;
	private String relationShip;
	private String qualification;
	private String marital_status;
	private String d_no;
	private String street;
	private String city;
	private String state;
	private String pincode;
}
