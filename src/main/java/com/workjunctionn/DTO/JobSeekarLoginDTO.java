package com.workjunctionn.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class JobSeekarLoginDTO {
	
	@NotNull(message = "Email not matches")
	@Email(message = "Incorrect email format")
	private String email;
	
	@NotNull(message = "Password not matches")
	private String password;
	

}
