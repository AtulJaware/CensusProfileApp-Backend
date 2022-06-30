package com.project.CensusProfiling.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name="application_data")
public class ApplicationEntity {
	
	@Id
//	@SequenceGenerator(name="ADD_SEQ_GEN", sequenceName="ADD_SEQ_GEN", allocationSize=1)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ADD_SEQ_GEN")
	@Min(1)
	private int id;
	
	@NotNull(message = "status is mandatory")
	private String status;
	
	@Positive (message = "user_id should be greater than 0")
	private int  user_id;


	public ApplicationEntity() {
		super();
	}

	public ApplicationEntity(@Min(1) int id, @NotNull(message = "status is mandatory") String status,
			@Positive(message = "user_id should be greater than 0") int user_id) {
		super();
		this.id = id;
		this.status = status;
		this.user_id = user_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "AppicationEntity [id=" + id + ", status=" + status + ", user_id=" + user_id + "]";
	}
	
	
}
