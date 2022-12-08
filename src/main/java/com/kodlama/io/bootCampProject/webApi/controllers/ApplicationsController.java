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

import com.kodlama.io.bootCampProject.business.abstracts.ApplicationService;
import com.kodlama.io.bootCampProject.business.requests.ApplicationRequest.CreateApplicationRequest;
import com.kodlama.io.bootCampProject.business.requests.ApplicationRequest.UpdateApplicationRequest;
import com.kodlama.io.bootCampProject.business.responses.ApplicationResponse.CreateApplicationResponse;
import com.kodlama.io.bootCampProject.business.responses.ApplicationResponse.GetAllApplicationResponse;
import com.kodlama.io.bootCampProject.business.responses.ApplicationResponse.GetApplicationResponse;
import com.kodlama.io.bootCampProject.business.responses.ApplicationResponse.UpdateApplicationResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/applications/")
@AllArgsConstructor
public class ApplicationsController {
	private ApplicationService applicationService;
	@GetMapping("/{id}")
	public DataResult<GetApplicationResponse> getById(@PathVariable int id){
		return this.applicationService.getById(id);
	}
	
	@GetMapping()
	public DataResult<List<GetAllApplicationResponse>> getAll(){
		return this.applicationService.getAll();
	}
	
	@PostMapping()
	DataResult<CreateApplicationResponse> add(@RequestBody CreateApplicationRequest createApplicationRequest){
		return this.applicationService.add(createApplicationRequest);
	}
	
	@PutMapping()
	 DataResult<UpdateApplicationResponse> update (@RequestBody UpdateApplicationRequest updateApplicationRequest){
		return this.applicationService.update(updateApplicationRequest);
	}	
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return this.applicationService.delete(id);
	}
}
