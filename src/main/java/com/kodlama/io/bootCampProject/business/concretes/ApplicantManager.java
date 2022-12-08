package com.kodlama.io.bootCampProject.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlama.io.bootCampProject.business.abstracts.ApplicantService;
import com.kodlama.io.bootCampProject.business.constants.Messages;
import com.kodlama.io.bootCampProject.business.requests.ApplicantRequest.CreateApplicantRequest;
import com.kodlama.io.bootCampProject.business.requests.ApplicantRequest.UpdateApplicantRequest;
import com.kodlama.io.bootCampProject.business.responses.ApplicantResponse.CreateApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.ApplicantResponse.GetAllApplicantReponse;
import com.kodlama.io.bootCampProject.business.responses.ApplicantResponse.GetApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.ApplicantResponse.UpdateApplicantResponse;
import com.kodlama.io.bootCampProject.core.utilities.exceptions.BusinessException;
import com.kodlama.io.bootCampProject.core.utilities.mapping.ModelMapperService;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessDataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessResult;
import com.kodlama.io.bootCampProject.dataAccess.abstracts.ApplicantRepository;
import com.kodlama.io.bootCampProject.entities.users.Applicant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ApplicantManager implements ApplicantService {
	private ApplicantRepository applicantRepository;
	private ModelMapperService modelMapperService;

	@Override
	public Result delete(int id) {
		checkIfApplicantExistById(id);
		this.applicantRepository.deleteById(id);
		return new SuccessResult(Messages.ApplicantDeleted);
	}

	@Override
	public DataResult<CreateApplicantResponse> add(CreateApplicantRequest createApplicantRequest) {
		checkIfApplicantExistByNationalIdentity(createApplicantRequest.getNationalIdentity());
		LocalDate dateOfBirth = stringToLocalDate(createApplicantRequest.getDateOfBirth());
		Applicant applicant = this.modelMapperService.forRequest().map(createApplicantRequest, Applicant.class);
		applicant.setDateOfBirth(dateOfBirth);
		this.applicantRepository.save(applicant);
		CreateApplicantResponse createApplicantResponse = this.modelMapperService.forResponse().map(applicant,
				CreateApplicantResponse.class);
		return new SuccessDataResult<CreateApplicantResponse>(createApplicantResponse, Messages.ApplicantCreated);
	}

	@Override
	public DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateApplicantRequest) {
		checkIfApplicantExistById(updateApplicantRequest.getId());
		Applicant applicant = this.modelMapperService.forRequest().map(updateApplicantRequest, Applicant.class);
		this.applicantRepository.save(applicant);
		UpdateApplicantResponse updateApplicantResponse = this.modelMapperService.forResponse().map(applicant,
				UpdateApplicantResponse.class);
		return new SuccessDataResult<UpdateApplicantResponse>(updateApplicantResponse, Messages.ApplicantUpdated);
	}

	@Override
	public DataResult<List<GetAllApplicantReponse>> getAll() {
		List<Applicant> applicants = this.applicantRepository.findAll();
		List<GetAllApplicantReponse> response = applicants.stream()
				.map(applicant -> this.modelMapperService.forResponse().map(applicants, GetAllApplicantReponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllApplicantReponse>>(response);
	}

	@Override
	public DataResult<GetApplicantResponse> getById(int id) {
		checkIfApplicantExistById(id);
		Applicant applicant = this.applicantRepository.findById(id).get();
		GetApplicantResponse response = this.modelMapperService.forResponse().map(applicant,
				GetApplicantResponse.class);
		return new SuccessDataResult<GetApplicantResponse>(response);
	}

	private void checkIfApplicantExistById(int id) {
		if (!applicantRepository.existsById(id)) {
			throw new BusinessException(Messages.ApplicantNotExists);
		}
	}

	private void checkIfApplicantExistByNationalIdentity(String nationalIdentity) {
		if (applicantRepository.existsByNationalIdentity(nationalIdentity)) {
			throw new BusinessException(Messages.ApplicantExists);
		}
	}

	private LocalDate stringToLocalDate(String dateOfBirth) {
		return LocalDate.parse(dateOfBirth);

	}


}
