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

import com.kodlama.io.bootCampProject.business.abstracts.BootcampService;
import com.kodlama.io.bootCampProject.business.requests.BootcampRequest.CreateBootcampRequest;
import com.kodlama.io.bootCampProject.business.requests.BootcampRequest.UpdateBootcampRequest;
import com.kodlama.io.bootCampProject.business.responses.BootcampResponse.CreateBootcampResponse;
import com.kodlama.io.bootCampProject.business.responses.BootcampResponse.GetAllBootcampResponse;
import com.kodlama.io.bootCampProject.business.responses.BootcampResponse.GetBootcampResponse;
import com.kodlama.io.bootCampProject.business.responses.BootcampResponse.UpdateBootcampResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/bootcamps/")
@AllArgsConstructor
public class BootcampController {
	private BootcampService bootcampService;
	@GetMapping("/{id}")
	public DataResult<GetBootcampResponse> getById(@PathVariable int id){
		return this.bootcampService.getById(id);
	}
	
	@GetMapping()
	public DataResult<List<GetAllBootcampResponse>> getAll(){
		return this.bootcampService.getAll();
	}
	@PostMapping()
	DataResult<CreateBootcampResponse> add(@RequestBody CreateBootcampRequest createBootcampRequest){
		return this.bootcampService.add(createBootcampRequest);
	}
	
	@PutMapping()
	 DataResult<UpdateBootcampResponse> update (@RequestBody UpdateBootcampRequest updateBootcampRequest){
		return this.bootcampService.update(updateBootcampRequest);
	}	
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return this.bootcampService.delete(id);
	}
}
