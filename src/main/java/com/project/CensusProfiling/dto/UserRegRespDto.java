package com.project.CensusProfiling.dto;

import java.time.LocalDate;

import lombok.Data;
@Data
public class UserRegRespDto {

	private int userId;
	private String firstName;
	private String lastName;
	private LocalDate DOB;
	private String contactNo;
	private String email;
	private boolean isLoggedIn ;
	private String role;
}
