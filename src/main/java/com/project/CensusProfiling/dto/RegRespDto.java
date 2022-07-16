package com.project.CensusProfiling.dto;

import lombok.Data;

@Data
public class RegRespDto {

	private int adminId;
	private String name;
	private String contact;
	private String email;
	private boolean isLoggedIn ;
	private String role;
}