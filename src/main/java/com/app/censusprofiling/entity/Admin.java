package com.app.censusprofiling.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="admin")
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

	@Id
	@SequenceGenerator(name="ADD_SEQ_GEN", sequenceName="ADD_SEQ_GEN", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ADD_SEQ_GEN")
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