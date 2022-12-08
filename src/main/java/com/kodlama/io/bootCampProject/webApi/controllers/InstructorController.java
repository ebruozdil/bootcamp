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

import com.kodlama.io.bootCampProject.business.abstracts.InstructorService;
import com.kodlama.io.bootCampProject.business.requests.InstructorRequest.CreateInstructorRequest;
import com.kodlama.io.bootCampProject.business.requests.InstructorRequest.UpdateInstructorRequest;
import com.kodlama.io.bootCampProject.business.responses.InstructorResponse.CreateInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.InstructorResponse.GetAllInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.InstructorResponse.GetInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.InstructorResponse.UpdateInstructorResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;
@RestController
@RequestMapping("/api/instructors/")
@AllArgsConstructor
public class InstructorController {
	private InstructorService instructorService;
	
	@GetMapping("/{id}")
	public DataResult<GetInstructorResponse> getById(@PathVariable int id){
		return this.instructorService.getById(id);
	}
	@GetMapping()
	public DataResult<List<GetAllInstructorResponse>> getAll(){
		return this.instructorService.getAll();
	}
	@PostMapping()
	public DataResult<CreateInstructorResponse> add (@RequestBody CreateInstructorRequest createInstructorRequest){
		return this.instructorService.add(createInstructorRequest);
	}
	
	@PutMapping()
	public DataResult<UpdateInstructorResponse> update (@RequestBody UpdateInstructorRequest updateInstructorRequest){
		return this.instructorService.update(updateInstructorRequest);
	}	
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return this.instructorService.delete(id);
	}
}
