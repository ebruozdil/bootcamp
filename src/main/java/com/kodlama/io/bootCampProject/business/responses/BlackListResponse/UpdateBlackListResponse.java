package com.kodlama.io.bootCampProject.business.responses.BlackListResponse;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBlackListResponse {
	private int id;
	private int applicantId;
	private LocalDate dateOfBan;
	private String reason;

}
