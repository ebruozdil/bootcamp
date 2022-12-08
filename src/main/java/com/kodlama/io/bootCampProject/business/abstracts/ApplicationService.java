package com.kodlama.io.bootCampProject.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlama.io.bootCampProject.business.requests.ApplicationRequest.CreateApplicationRequest;
import com.kodlama.io.bootCampProject.business.requests.ApplicationRequest.UpdateApplicationRequest;
import com.kodlama.io.bootCampProject.business.responses.ApplicationResponse.CreateApplicationResponse;
import com.kodlama.io.bootCampProject.business.responses.ApplicationResponse.GetAllApplicationResponse;
import com.kodlama.io.bootCampProject.business.responses.ApplicationResponse.GetApplicationResponse;
import com.kodlama.io.bootCampProject.business.responses.ApplicationResponse.UpdateApplicationResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;

@Service
public interface ApplicationService {
	Result delete(int id);
	DataResult<CreateApplicationResponse> add(CreateApplicationRequest createApplicationRequest);
	DataResult<UpdateApplicationResponse> update(UpdateApplicationRequest updateApplicationRequest);
	DataResult<List<GetAllApplicationResponse>> getAll();
	DataResult<GetApplicationResponse> getById(int id);

}
