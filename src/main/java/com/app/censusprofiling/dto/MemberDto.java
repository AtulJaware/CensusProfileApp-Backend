package com.app.censusprofiling.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

	private int memId;
	private String firstName;
	private String lastName;
	private LocalDate DOB;
	private String gender;
	private String relationShip;
	private String qualification;
	private String marital_status;
	private int id;
	private String d_no;
	private String street;
	private String city;
	private String state;
	private String pincode;
}