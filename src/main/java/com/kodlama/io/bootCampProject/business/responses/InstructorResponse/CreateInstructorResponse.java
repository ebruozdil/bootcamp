package com.kodlama.io.bootCampProject.business.responses.InstructorResponse;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInstructorResponse {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String companyName;
	private LocalDate dateOfBirth;
	private String nationalIdentity;


}
