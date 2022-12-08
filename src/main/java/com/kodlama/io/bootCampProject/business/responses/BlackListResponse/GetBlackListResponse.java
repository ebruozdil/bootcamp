package com.kodlama.io.bootCampProject.business.responses.BlackListResponse;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor

public class GetBlackListResponse {
	private int id;
	private int applicantId;
	private LocalDate dateOfBan;
	private String reason;

}
