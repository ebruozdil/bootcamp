package com.kodlama.io.bootCampProject.business.requests.InstructorRequest;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInstructorRequest {
	
	@NotEmpty
	@Size(min = 3)
	private String firstName;
	
	@NotEmpty
	private String lastName;
	
	@Email
	private String email;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	private String companyName;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private String dateOfBirth;
	
	@NotEmpty
	@Size(min = 11, max = 11)
	private String nationalIdentity;

}
 