package com.kodlama.io.bootCampProject.business.responses.BootcampResponse;

import java.time.LocalDate;

import com.kodlama.io.bootCampProject.business.enums.BootcampState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBootcampResponse {
	private int id;
	private String name;
	private LocalDate dateStart;
	private LocalDate dateEnd;
	private BootcampState bootcampState;
	private int instructorId;
}
