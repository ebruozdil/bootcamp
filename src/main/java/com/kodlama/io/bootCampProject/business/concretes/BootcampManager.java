package com.kodlama.io.bootCampProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlama.io.bootCampProject.business.abstracts.BootcampService;
import com.kodlama.io.bootCampProject.business.abstracts.InstructorService;
import com.kodlama.io.bootCampProject.business.constants.BusinessMessages;
import com.kodlama.io.bootCampProject.business.constants.Messages;
import com.kodlama.io.bootCampProject.business.requests.BootcampRequest.CreateBootcampRequest;
import com.kodlama.io.bootCampProject.business.requests.BootcampRequest.UpdateBootcampRequest;
import com.kodlama.io.bootCampProject.business.responses.BootcampResponse.CreateBootcampResponse;
import com.kodlama.io.bootCampProject.business.responses.BootcampResponse.GetAllBootcampResponse;
import com.kodlama.io.bootCampProject.business.responses.BootcampResponse.GetBootcampResponse;
import com.kodlama.io.bootCampProject.business.responses.BootcampResponse.UpdateBootcampResponse;
import com.kodlama.io.bootCampProject.core.utilities.exceptions.BusinessException;
import com.kodlama.io.bootCampProject.core.utilities.mapping.ModelMapperService;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessDataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessResult;
import com.kodlama.io.bootCampProject.dataAccess.abstracts.BootcampRepository;
import com.kodlama.io.bootCampProject.entities.bootcamps.Bootcamps;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BootcampManager implements BootcampService {
	private BootcampRepository bootcampRepository;
	private ModelMapperService modelMapperService;
	private InstructorService instructorService;

	@Override
	public Result delete(int id) {
		this.bootcampRepository.deleteById(id);
		checkIfBootcampExistsById(id);
		return new SuccessResult(Messages.BootcampDeleted);
	}

	@Override
	public DataResult<CreateBootcampResponse> add(CreateBootcampRequest createBootcampRequest) {
		checkIfInstructorExists(createBootcampRequest.getInstructorId());
		Bootcamps bootcamp = this.modelMapperService.forRequest().map(createBootcampRequest, Bootcamps.class);
		this.bootcampRepository.save(bootcamp);
		CreateBootcampResponse createBootcampResponse = this.modelMapperService.forResponse().map(bootcamp,
				CreateBootcampResponse.class);
		return new SuccessDataResult<CreateBootcampResponse>(createBootcampResponse, Messages.BootcampCreated);
	}

	@Override
	public DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest updateBootcampRequest) {
		checkIfInstructorExists(updateBootcampRequest.getInstructorId());
		checkIfBootcampExistsById(updateBootcampRequest.getId());
		Bootcamps bootcamp = this.modelMapperService.forRequest().map(updateBootcampRequest, Bootcamps.class);
		this.bootcampRepository.save(bootcamp);
		UpdateBootcampResponse updateBootcampResponse = this.modelMapperService.forResponse().map(bootcamp,
				UpdateBootcampResponse.class);
		return new SuccessDataResult<UpdateBootcampResponse>(updateBootcampResponse, Messages.BootcampUpdated);
	}

	@Override
	public DataResult<List<GetAllBootcampResponse>> getAll() {
		List<Bootcamps> bootcamp = this.bootcampRepository.findAll();
		List<GetAllBootcampResponse> response = bootcamp.stream()
				.map(bootcamps -> this.modelMapperService.forResponse().map(bootcamp, GetAllBootcampResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllBootcampResponse>>(response);
	}

	@Override
	public DataResult<GetBootcampResponse> getById(int id) {
		checkIfBootcampExistsById(id);
		Bootcamps bootcamp = this.bootcampRepository.findById(id).get();
		GetBootcampResponse response = this.modelMapperService.forResponse().map(bootcamp, GetBootcampResponse.class);
		return new SuccessDataResult<GetBootcampResponse>(response);
	}

	private void checkIfBootcampExistsById(int id) {
		Bootcamps bootcamp = bootcampRepository.findById(id).orElse(null);
		if (bootcamp == null) {
			throw new BusinessException(BusinessMessages.BootcampNoExists);
		}
	}

	private void checkIfInstructorExists(int instructorId) {
		var result = instructorService.getById(instructorId);
		if (result == null) {
			throw new BusinessException(BusinessMessages.InstructorNoExists);
		}
	}

}
