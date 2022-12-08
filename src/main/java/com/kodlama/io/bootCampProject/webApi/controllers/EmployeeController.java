package com.kodlama.io.bootCampProject.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.bootCampProject.business.abstracts.EmployeeService;
import com.kodlama.io.bootCampProject.business.requests.EmployeeRequest.CreateEmployeeRequest;
import com.kodlama.io.bootCampProject.business.requests.EmployeeRequest.UpdateEmployeeRequest;
import com.kodlama.io.bootCampProject.business.responses.EmployeeResponse.CreateEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.EmployeeResponse.GetAllEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.EmployeeResponse.GetEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.EmployeeResponse.UpdateEmployeeResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;
@RestController
@RequestMapping("/api/employees/")
@AllArgsConstructor
public class EmployeeController {
	private EmployeeService employeeService;
	@GetMapping("/{id}")
	public DataResult<GetEmployeeResponse> getById(@PathVariable int id){
		return this.employeeService.getById(id);
	}
	@GetMapping()
	public DataResult<List<GetAllEmployeeResponse>> getAll(){
		return this.employeeService.getAll();
	}
	@PostMapping()
	DataResult<CreateEmployeeResponse> add (@RequestBody CreateEmployeeRequest createEmployeeRequest){
		return this.employeeService.add(createEmployeeRequest);
	}
	
	@PutMapping()
	 DataResult<UpdateEmployeeResponse> update (@RequestBody UpdateEmployeeRequest updateEmployeeRequest){
		return this.employeeService.update(updateEmployeeRequest);
	}	
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return this.employeeService.delete(id);
	}
}
