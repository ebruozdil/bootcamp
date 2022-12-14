package com.kodlama.io.bootCampProject.business.responses.ApplicantResponse;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetApplicantResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String about;
    private String nationalIdentity;
    private LocalDate dateOfBirth;

}
