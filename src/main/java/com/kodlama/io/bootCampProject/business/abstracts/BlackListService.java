package com.kodlama.io.bootCampProject.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlama.io.bootCampProject.business.requests.BlackListRequest.CreateBlackListRequest;
import com.kodlama.io.bootCampProject.business.requests.BlackListRequest.UpdateBlackListRequest;
import com.kodlama.io.bootCampProject.business.responses.BlackListResponse.CreateBlackListResponse;
import com.kodlama.io.bootCampProject.business.responses.BlackListResponse.GetAllBlackListResponse;
import com.kodlama.io.bootCampProject.business.responses.BlackListResponse.GetBlackListResponse;
import com.kodlama.io.bootCampProject.business.responses.BlackListResponse.UpdateBlackListResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;

@Service
public interface BlackListService {
	Result delete(int id);

	DataResult<CreateBlackListResponse> add(CreateBlackListRequest createBlackListRequest);

	DataResult<UpdateBlackListResponse> update(UpdateBlackListRequest updateBlackListRequest);

	DataResult<List<GetAllBlackListResponse>> getAll();

	DataResult<GetBlackListResponse> getById(int id);

}
