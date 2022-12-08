package com.kodlama.io.bootCampProject.business.requests.EmployeeRequest;

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
public class UpdateEmployeeRequest {

	@Min(0)
	private int id;

	@Size(min = 3)
	private String firstName;

	private String lastName;
	@Email
	private String email;

	private String password;

	private String position;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dateOfBirth;

	@Size(min = 11, max = 11)
	private String nationalIdentity;

}
