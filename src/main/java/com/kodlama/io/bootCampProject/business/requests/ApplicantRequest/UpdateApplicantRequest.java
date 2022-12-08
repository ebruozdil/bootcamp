package com.kodlama.io.bootCampProject.business.requests.ApplicantRequest;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApplicantRequest {
	
	@NotNull
	@Min(0)
    private int id;
	
	@NotEmpty
	@Size(min = 3)
    private String firstName;
	
	@NotEmpty
    private String lastName;
	
	@NotEmpty
    private String email;
	
	@NotEmpty
    private String password;
	
	@NotEmpty
    private String about;
    
	@NotEmpty
	@Size(min = 11, max = 11)
    private String nationalIdentity;
	
	@NotEmpty
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;


}
