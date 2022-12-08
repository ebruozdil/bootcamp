package com.kodlama.io.bootCampProject.business.responses.ApplicationResponse;

import com.kodlama.io.bootCampProject.business.enums.ApplicationState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicationResponse {
	private int id;
	private int applicantId;
	private int bootcampId;
	private ApplicationState applicationState;

}
