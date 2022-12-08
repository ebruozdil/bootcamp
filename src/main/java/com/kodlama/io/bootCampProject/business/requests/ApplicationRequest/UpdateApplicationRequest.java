package com.kodlama.io.bootCampProject.business.requests.ApplicationRequest;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.kodlama.io.bootCampProject.business.enums.ApplicationState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApplicationRequest {

	@NotNull
	@Min(0)
	private int id;

	@NotNull
	@Min(0)
	private int applicantId;

	@NotNull
	@Min(0)
	private int bootcampId;

	private ApplicationState applicationState;
}
