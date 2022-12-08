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

import com.kodlama.io.bootCampProject.business.abstracts.BlackListService;
import com.kodlama.io.bootCampProject.business.requests.BlackListRequest.CreateBlackListRequest;
import com.kodlama.io.bootCampProject.business.requests.BlackListRequest.UpdateBlackListRequest;
import com.kodlama.io.bootCampProject.business.responses.BlackListResponse.CreateBlackListResponse;
import com.kodlama.io.bootCampProject.business.responses.BlackListResponse.GetAllBlackListResponse;
import com.kodlama.io.bootCampProject.business.responses.BlackListResponse.GetBlackListResponse;
import com.kodlama.io.bootCampProject.business.responses.BlackListResponse.UpdateBlackListResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("/api/blackList/")
public class BlackListController {
	private BlackListService blackListService;
	@GetMapping("/{id}")
	public DataResult<GetBlackListResponse> getById(@PathVariable int id){
		return this.blackListService.getById(id);
	}
	
	@GetMapping()
	public DataResult<List<GetAllBlackListResponse>> getAll(){
		return this.blackListService.getAll();
	}
	
	@PostMapping()
	DataResult<CreateBlackListResponse> add(@RequestBody CreateBlackListRequest createBlackListRequest){
		return this.blackListService.add(createBlackListRequest);
	}
	
	@PutMapping()
	 DataResult<UpdateBlackListResponse> update (@RequestBody UpdateBlackListRequest updateBlackListRequest){
		return this.blackListService.update(updateBlackListRequest);
	}	
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return this.blackListService.delete(id);
	}

}
