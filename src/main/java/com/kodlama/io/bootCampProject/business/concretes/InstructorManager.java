package com.kodlama.io.bootCampProject.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlama.io.bootCampProject.business.abstracts.InstructorService;
import com.kodlama.io.bootCampProject.business.constants.Messages;
import com.kodlama.io.bootCampProject.business.requests.InstructorRequest.CreateInstructorRequest;
import com.kodlama.io.bootCampProject.business.requests.InstructorRequest.UpdateInstructorRequest;
import com.kodlama.io.bootCampProject.business.responses.InstructorResponse.CreateInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.InstructorResponse.GetAllInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.InstructorResponse.GetInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.InstructorResponse.UpdateInstructorResponse;
import com.kodlama.io.bootCampProject.core.utilities.exceptions.BusinessException;
import com.kodlama.io.bootCampProject.core.utilities.mapping.ModelMapperService;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessDataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessResult;
import com.kodlama.io.bootCampProject.dataAccess.abstracts.InstructorRepository;
import com.kodlama.io.bootCampProject.entities.users.Instructor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service

public class InstructorManager implements InstructorService {
	private InstructorRepository instructorRepository;
	private ModelMapperService modelMapperService;

	@Override
	public Result delete(int id) {
		checkIfInstructorExistById(id);
		this.instructorRepository.deleteById(id);

		return new SuccessResult(Messages.InstructorDeleted);
	}

	@Override
	public DataResult<CreateInstructorResponse> add(CreateInstructorRequest createInstructorRequest) {
		checkIfInstructorExistByNationalIdentity(createInstructorRequest.getNationalIdentity());
		LocalDate dateOfBirth = stringToLocalDate(createInstructorRequest.getDateOfBirth());
		Instructor instructor = this.modelMapperService.forRequest().map(createInstructorRequest, Instructor.class);
		instructor.setDateOfBirth(dateOfBirth);
		this.instructorRepository.save(instructor);
		CreateInstructorResponse createInstructorResponse = this.modelMapperService.forResponse().map(instructor,
				CreateInstructorResponse.class);
		return new SuccessDataResult<CreateInstructorResponse>(createInstructorResponse, Messages.InstructorCreated);
	}

	@Override
	public DataResult<List<GetAllInstructorResponse>> getAll() {
		List<Instructor> instructors = this.instructorRepository.findAll();
		List<GetAllInstructorResponse> response = instructors.stream().map(
				instructor -> this.modelMapperService.forResponse().map(instructor, GetAllInstructorResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllInstructorResponse>>(response);
	}

	@Override
	public DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest updateInstructorRequest) {
		checkIfInstructorExistById(updateInstructorRequest.getId());
		Instructor instructor = this.modelMapperService.forRequest().map(updateInstructorRequest, Instructor.class);
		this.instructorRepository.save(instructor);
		UpdateInstructorResponse updateInstructorResponse = this.modelMapperService.forResponse().map(instructor,
				UpdateInstructorResponse.class);
		return new SuccessDataResult<UpdateInstructorResponse>(updateInstructorResponse, Messages.InstructorUpdated);
	}

	@Override
	public DataResult<GetInstructorResponse> getById(int id) {
		Instructor instructor = this.instructorRepository.findById(id).get();
		GetInstructorResponse response = this.modelMapperService.forResponse().map(instructor,
				GetInstructorResponse.class);
		return new SuccessDataResult<GetInstructorResponse>(response);
	}

	private void checkIfInstructorExistById(int id) {
		if (!instructorRepository.existsById(id)) {
			throw new BusinessException(Messages.InstructorNotExists);
		}
	}

	private void checkIfInstructorExistByNationalIdentity(String nationalIdentity) {
		if (instructorRepository.existsByNationalIdentity(nationalIdentity)) {
			throw new BusinessException(Messages.InstructorExists);
		}
	}

	private LocalDate stringToLocalDate(String dateOfBirth) {
		return LocalDate.parse(dateOfBirth);

	}
}
