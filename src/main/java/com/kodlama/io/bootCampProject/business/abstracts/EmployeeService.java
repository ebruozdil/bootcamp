package com.kodlama.io.bootCampProject.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlama.io.bootCampProject.business.requests.EmployeeRequest.CreateEmployeeRequest;
import com.kodlama.io.bootCampProject.business.requests.EmployeeRequest.UpdateEmployeeRequest;
import com.kodlama.io.bootCampProject.business.responses.EmployeeResponse.CreateEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.EmployeeResponse.GetAllEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.EmployeeResponse.GetEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.EmployeeResponse.UpdateEmployeeResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;
@Service
public interface EmployeeService {
	Result delete(int id);
	DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest createEmployeeRequest);
	DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest updateEmployeeRequest);
	DataResult<List<GetAllEmployeeResponse>> getAll();
	DataResult<GetEmployeeResponse> getById(int id);

}
