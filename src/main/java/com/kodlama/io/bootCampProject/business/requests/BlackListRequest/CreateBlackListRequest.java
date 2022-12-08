package com.kodlama.io.bootCampProject.business.requests.BlackListRequest;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBlackListRequest {
	
	@NotNull
	@Min(0)
	private int applicantId;
	
	@NotEmpty
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private String dateOfBan;
	
	@NotEmpty
	private String reason;
}
