package com.kodlama.io.bootCampProject.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlama.io.bootCampProject.business.abstracts.ApplicantService;
import com.kodlama.io.bootCampProject.business.abstracts.BlackListService;
import com.kodlama.io.bootCampProject.business.constants.BusinessMessages;
import com.kodlama.io.bootCampProject.business.constants.Messages;
import com.kodlama.io.bootCampProject.business.requests.BlackListRequest.CreateBlackListRequest;
import com.kodlama.io.bootCampProject.business.requests.BlackListRequest.UpdateBlackListRequest;
import com.kodlama.io.bootCampProject.business.responses.BlackListResponse.CreateBlackListResponse;
import com.kodlama.io.bootCampProject.business.responses.BlackListResponse.GetAllBlackListResponse;
import com.kodlama.io.bootCampProject.business.responses.BlackListResponse.GetBlackListResponse;
import com.kodlama.io.bootCampProject.business.responses.BlackListResponse.UpdateBlackListResponse;
import com.kodlama.io.bootCampProject.core.utilities.exceptions.BusinessException;
import com.kodlama.io.bootCampProject.core.utilities.mapping.ModelMapperService;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessDataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessResult;
import com.kodlama.io.bootCampProject.dataAccess.abstracts.BlackListRepository;
import com.kodlama.io.bootCampProject.entities.evaluations.BlackList;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class BlackListManager implements BlackListService{
	private BlackListRepository blackListRepository;
	private ModelMapperService modelMapperService;
	private ApplicantService applicantService;


	@Override
	public Result delete(int id) {
		checkIfBlackListExistsById(id);
		this.blackListRepository.deleteById(id);
		return new SuccessResult(Messages.BlackListDeleted);
	}

	@Override
	public DataResult<CreateBlackListResponse> add(CreateBlackListRequest createBlackListRequest) {
		LocalDate dateOfBan= stringToLocalDate(createBlackListRequest.getDateOfBan());
		checkIfApplicantExists(createBlackListRequest.getApplicantId());
		BlackList blackList= this.modelMapperService.forRequest().map(createBlackListRequest, BlackList.class);
		blackList.setDateOfBan(dateOfBan);
		this.blackListRepository.save(blackList);
		CreateBlackListResponse createBlackListResponse=this.modelMapperService.forResponse().map(blackList, CreateBlackListResponse.class);
		return new SuccessDataResult<CreateBlackListResponse>(createBlackListResponse,Messages.BlackListCreated);
	}

	@Override
	public DataResult<UpdateBlackListResponse> update(UpdateBlackListRequest updateBlackListRequest) {
		checkIfApplicantExists(updateBlackListRequest.getApplicantId());
		checkIfBlackListExistsById(updateBlackListRequest.getId());
		BlackList blackList= this.modelMapperService.forRequest().map(updateBlackListRequest, BlackList.class);
		this.blackListRepository.save(blackList);
		UpdateBlackListResponse updateBlackListResponse=this.modelMapperService.forResponse().map(blackList, UpdateBlackListResponse.class);
		return new SuccessDataResult<UpdateBlackListResponse>(updateBlackListResponse,Messages.BlackListUpdated);
	}

	@Override
	public DataResult<List<GetAllBlackListResponse>> getAll() {
		List<BlackList> blackList = this.blackListRepository.findAll();
		List<GetAllBlackListResponse> response= blackList.stream().map(blackLists->this.modelMapperService.forResponse().map(blackList, GetAllBlackListResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllBlackListResponse>>(response);
	}

	@Override
	public DataResult<GetBlackListResponse> getById(int id) {
		checkIfBlackListExistsById(id);
		BlackList blackList=this.blackListRepository.findById(id).get();
		GetBlackListResponse response= this.modelMapperService.forResponse().map(blackList, GetBlackListResponse.class);
		return new SuccessDataResult<GetBlackListResponse>(response);
	}
	
	private LocalDate stringToLocalDate(String dateOfBan) {
		return LocalDate.parse(dateOfBan);
		
	}
	
	private void checkIfBlackListExistsById(int id) {
		BlackList blackList = blackListRepository.findById(id).orElse(null);
		if (blackList == null) {
			throw new BusinessException(BusinessMessages.BlackListNoExists);
		}
	}

	private void checkIfApplicantExists(int applicantId) {
		var result = applicantService.getById(applicantId);
		if (result == null) {
			throw new BusinessException(BusinessMessages.ApplicantNoExists);
		}
	}

	

}
