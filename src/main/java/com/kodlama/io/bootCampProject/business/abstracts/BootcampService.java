package com.kodlama.io.bootCampProject.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlama.io.bootCampProject.business.requests.BootcampRequest.CreateBootcampRequest;
import com.kodlama.io.bootCampProject.business.requests.BootcampRequest.UpdateBootcampRequest;
import com.kodlama.io.bootCampProject.business.responses.BootcampResponse.CreateBootcampResponse;
import com.kodlama.io.bootCampProject.business.responses.BootcampResponse.GetAllBootcampResponse;
import com.kodlama.io.bootCampProject.business.responses.BootcampResponse.GetBootcampResponse;
import com.kodlama.io.bootCampProject.business.responses.BootcampResponse.UpdateBootcampResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;

@Service
public interface BootcampService {
	Result delete(int id);
	DataResult<CreateBootcampResponse> add(CreateBootcampRequest createBootcampRequest);
	DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest updateBootcampRequest);
	DataResult<List<GetAllBootcampResponse>> getAll();
	DataResult<GetBootcampResponse> getById(int id);
}
