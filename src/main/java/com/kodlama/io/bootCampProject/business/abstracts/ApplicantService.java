package com.kodlama.io.bootCampProject.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlama.io.bootCampProject.business.requests.ApplicantRequest.CreateApplicantRequest;
import com.kodlama.io.bootCampProject.business.requests.ApplicantRequest.UpdateApplicantRequest;
import com.kodlama.io.bootCampProject.business.responses.ApplicantResponse.CreateApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.ApplicantResponse.GetAllApplicantReponse;
import com.kodlama.io.bootCampProject.business.responses.ApplicantResponse.GetApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.ApplicantResponse.UpdateApplicantResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;

@Service
public interface ApplicantService {
	Result delete(int id);
	DataResult<CreateApplicantResponse> add(CreateApplicantRequest createApplicantRequest);
	DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateApplicantRequest);
	DataResult<List<GetAllApplicantReponse>> getAll();
	DataResult<GetApplicantResponse> getById(int id);

}
