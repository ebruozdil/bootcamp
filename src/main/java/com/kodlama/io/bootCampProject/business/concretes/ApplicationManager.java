package com.kodlama.io.bootCampProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlama.io.bootCampProject.business.abstracts.ApplicationService;
import com.kodlama.io.bootCampProject.business.constants.Messages;
import com.kodlama.io.bootCampProject.business.requests.ApplicationRequest.CreateApplicationRequest;
import com.kodlama.io.bootCampProject.business.requests.ApplicationRequest.UpdateApplicationRequest;
import com.kodlama.io.bootCampProject.business.responses.ApplicationResponse.CreateApplicationResponse;
import com.kodlama.io.bootCampProject.business.responses.ApplicationResponse.GetAllApplicationResponse;
import com.kodlama.io.bootCampProject.business.responses.ApplicationResponse.GetApplicationResponse;
import com.kodlama.io.bootCampProject.business.responses.ApplicationResponse.UpdateApplicationResponse;
import com.kodlama.io.bootCampProject.core.utilities.mapping.ModelMapperService;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessDataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessResult;
import com.kodlama.io.bootCampProject.dataAccess.abstracts.ApplicationsRepository;
import com.kodlama.io.bootCampProject.entities.applications.Applications;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ApplicationManager implements ApplicationService {
	private ApplicationsRepository applicationRepository;
	private ModelMapperService modelMapperService;
//	private BlackListService blackListService;
//	private ApplicantService applicantService;
//	private BootcampService bootcampService;

	@Override
	public Result delete(int id) {
//		checkIfApplicationExistsById(id);
		applicationRepository.deleteById(id);
		return new SuccessResult(Messages.ApplicationDeleted);
	}

	@Override
	public DataResult<CreateApplicationResponse> add(CreateApplicationRequest createApplicationRequest) {
//		checkIfApplicantExists(createApplicationRequest.getApplicantId());
//		checkIfBootcampExists(createApplicationRequest.getBootcampId());
//		checkIfApplicationExistsByBlackList(createApplicationRequest.getBootcampId(),
//				createApplicationRequest.getApplicantId());
		Applications application = this.modelMapperService.forRequest().map(createApplicationRequest,
				Applications.class);
		this.applicationRepository.save(application);
		CreateApplicationResponse createApplicationResponse = this.modelMapperService.forResponse().map(application,
				CreateApplicationResponse.class);
		return new SuccessDataResult<CreateApplicationResponse>(createApplicationResponse, Messages.ApplicationCreated);
	}

	@Override
	public DataResult<UpdateApplicationResponse> update(UpdateApplicationRequest updateApplicationRequest) {
//		checkIfApplicantExists(updateApplicationRequest.getApplicantId());
//		checkIfBootcampExists(updateApplicationRequest.getBootcampId());
//		checkIfApplicationExistsById(updateApplicationRequest.getId());

		Applications application = this.modelMapperService.forRequest().map(updateApplicationRequest,
				Applications.class);
		this.applicationRepository.save(application);
		UpdateApplicationResponse updateApplicationResponse = this.modelMapperService.forResponse().map(application,
				UpdateApplicationResponse.class);
		return new SuccessDataResult<UpdateApplicationResponse>(updateApplicationResponse, Messages.ApplicationUpdated);
	}

	@Override
	public DataResult<List<GetAllApplicationResponse>> getAll() {
		List<Applications> application = this.applicationRepository.findAll();
		List<GetAllApplicationResponse> response = application.stream().map(
				applications -> this.modelMapperService.forResponse().map(application, GetAllApplicationResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllApplicationResponse>>(response);
	}

	@Override
	public DataResult<GetApplicationResponse> getById(int id) {
		// checkIfApplicationExistsById(id);
		Applications applications = this.applicationRepository.findById(id).get();
		GetApplicationResponse response = this.modelMapperService.forResponse().map(applications,
				GetApplicationResponse.class);
		return new SuccessDataResult<GetApplicationResponse>(response);
	}

//	private void checkIfApplicationExistById (int id) {
//		if(!applicationRepository.existsById(id)) {
//			throw new BusinessException(Messages.ApplicationNotExists+id);
//		}
//	}
//	private void checkIfApplicationExistsById(int id) {
//		Applications application = applicationRepository.findById(id).orElse(null);
//		if (application == null) {
//			throw new BusinessException(BusinessMessages.ApplicationNoExists);
//		}
//	}

//	private void checkIfApplicationExistsByBlackList(int bootcampId, int applicantId) {
//		List<Applications> applications = this.applicationRepository.getApplicationByBootCampId(bootcampId);
//		for (Applications application : applications)
//			if (application.getApplicant().getId() == applicantId) {
//				throw new BusinessException(BusinessMessages.InBlackList);
//			}
//	}
//
//	private void checkIfApplicantExists(int applicantId) {
//		var result = applicantService.getById(applicantId);
//		if (result == null) {
//			throw new BusinessException(BusinessMessages.ApplicantNoExists);
//		}
//	}
//
//	private void checkIfBootcampExists(int bootcampId) {
//		var result = bootcampService.getById(bootcampId);
//		if (result == null) {
//			throw new BusinessException(BusinessMessages.BootcampNoExists);
//		}
//	}

}
