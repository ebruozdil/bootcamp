package com.kodlama.io.bootCampProject.business.requests.BootcampRequest;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kodlama.io.bootCampProject.business.enums.BootcampState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBootcampRequest {
	
	@NotNull
	@Min(0)
	private int id;

	@NotEmpty
	private String name;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateStart;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateEnd;
	
	@NotNull
	private BootcampState bootcampState;
	
	@NotNull
	@Min(0)
	private int instructorId;
}
