package com.app.censusprofiling.dto;

import lombok.Data;

@Data
public class AdminRegRespDto {

	private int adminId;
	private String name;
	private String contact;
	private String email;
	private boolean isLoggedIn ;
	private String role;
}