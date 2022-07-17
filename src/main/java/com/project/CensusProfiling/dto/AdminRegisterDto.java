package com.project.CensusProfiling.dto;

import lombok.Data;

@Data
public class AdminRegisterDto {
	
	private int adminId;
	private String name;
	private String contact;
	private String email;
	private String password;
	private String role;

}