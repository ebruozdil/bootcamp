package com.kodlama.io.bootCampProject.business.requests.InstructorRequest;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateInstructorRequest {

	@Min(0)
	private int id;

	@Size(min = 3)
	private String firstName;

	private String lastName;
	@Email
	private String email;

	private String password;

	private String companyName;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;

	@Size(min = 11, max = 11)
	private String nationalIdentity;
}
