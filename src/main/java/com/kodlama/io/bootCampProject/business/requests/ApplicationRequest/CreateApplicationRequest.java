package com.kodlama.io.bootCampProject.business.requests.ApplicationRequest;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicationRequest {

	@NotEmpty
	@Min(0)
	private int applicantId;

	@NotEmpty
	@Min(0)
	private int bootcampId;

}
