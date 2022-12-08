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

import com.kodlama.io.bootCampProject.business.abstracts.ApplicantService;
import com.kodlama.io.bootCampProject.business.requests.ApplicantRequest.CreateApplicantRequest;
import com.kodlama.io.bootCampProject.business.requests.ApplicantRequest.UpdateApplicantRequest;
import com.kodlama.io.bootCampProject.business.responses.ApplicantResponse.CreateApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.ApplicantResponse.GetAllApplicantReponse;
import com.kodlama.io.bootCampProject.business.responses.ApplicantResponse.GetApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.ApplicantResponse.UpdateApplicantResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;
@RestController
@RequestMapping("/api/applicants/")
@AllArgsConstructor
public class ApplicantController {
	private ApplicantService applicantService;
	@GetMapping("/{id}")
	public DataResult<GetApplicantResponse> getById(@PathVariable int id){
		return this.applicantService.getById(id);
	}
	@GetMapping()
	public DataResult<List<GetAllApplicantReponse>> getAll(){
		return this.applicantService.getAll();
	}
	@PostMapping()
	DataResult<CreateApplicantResponse> add(@RequestBody CreateApplicantRequest createApplicantRequest){
		return this.applicantService.add(createApplicantRequest);
	}
	
	@PutMapping()
	 DataResult<UpdateApplicantResponse> update (@RequestBody UpdateApplicantRequest updateApplicantRequest){
		return this.applicantService.update(updateApplicantRequest);
	}	
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return this.applicantService.delete(id);
	}

}
