package com.kodlama.io.bootCampProject.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlama.io.bootCampProject.business.requests.InstructorRequest.CreateInstructorRequest;
import com.kodlama.io.bootCampProject.business.requests.InstructorRequest.UpdateInstructorRequest;
import com.kodlama.io.bootCampProject.business.responses.InstructorResponse.CreateInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.InstructorResponse.GetAllInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.InstructorResponse.GetInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.InstructorResponse.UpdateInstructorResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;
@Service
public interface InstructorService {
	Result delete(int id);
	DataResult<CreateInstructorResponse> add(CreateInstructorRequest createInstructorRequest);
	DataResult<List<GetAllInstructorResponse>> getAll();
	DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest updateInstructorRequest);
	DataResult<GetInstructorResponse> getById(int id);

}
