package com.kodlama.io.bootCampProject.business.requests.BlackListRequest;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor

public class UpdateBlackListRequest {
	
	@NotNull
	@Min(0)
	private int id;
	
	@NotNull
	@Min(0)
	private int applicantId;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateOfBan;
	
	@NotEmpty
	private String reason;

}
