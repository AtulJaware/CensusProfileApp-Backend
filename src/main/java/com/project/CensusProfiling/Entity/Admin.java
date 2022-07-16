package com.project.CensusProfiling.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="admin_data")
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

	@Id
	@GeneratedValue
	private int adminId;
	
	@NotNull(message = "name is mandatory")
	private String name;
	
	@NotNull(message = "contact is mandatory")
	private String contact;
	
	// OneToOne unidirectional relationship 
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "email")
		private Login login;

		public Admin(int adminId2, String name2, String contact2, String string) {
			
		}
}