package com.kodlama.io.bootCampProject.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlama.io.bootCampProject.business.abstracts.EmployeeService;
import com.kodlama.io.bootCampProject.business.constants.Messages;
import com.kodlama.io.bootCampProject.business.requests.EmployeeRequest.CreateEmployeeRequest;
import com.kodlama.io.bootCampProject.business.requests.EmployeeRequest.UpdateEmployeeRequest;
import com.kodlama.io.bootCampProject.business.responses.EmployeeResponse.CreateEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.EmployeeResponse.GetAllEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.EmployeeResponse.GetEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.EmployeeResponse.UpdateEmployeeResponse;
import com.kodlama.io.bootCampProject.core.utilities.exceptions.BusinessException;
import com.kodlama.io.bootCampProject.core.utilities.mapping.ModelMapperService;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessDataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessResult;
import com.kodlama.io.bootCampProject.dataAccess.abstracts.EmployeeRepository;
import com.kodlama.io.bootCampProject.entities.users.Employee;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {
	private EmployeeRepository employeeRepository;
	private ModelMapperService modelMapperService;

	@Override
	public Result delete(int id) {
		this.employeeRepository.deleteById(id);
		;
		return new SuccessResult(Messages.EmployeeDeleted);
	}

	@Override
	public DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest createEmployeeRequest) {
		checkIfEmployeeExistByNationalIdentity(createEmployeeRequest.getNationalIdentity());
		LocalDate dateOfBirth = stringToLocalDate(createEmployeeRequest.getDateOfBirth());
		Employee employee = this.modelMapperService.forRequest().map(createEmployeeRequest, Employee.class);
		employee.setDateOfBirth(dateOfBirth);
		this.employeeRepository.save(employee);
		CreateEmployeeResponse createEmployeeResponse = this.modelMapperService.forResponse().map(employee,
				CreateEmployeeResponse.class);
		return new SuccessDataResult<CreateEmployeeResponse>(createEmployeeResponse, Messages.EmployeeCreated);
	}

	@Override
	public DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest updateEmployeeRequest) {
		checkIfEmployeeExistById(updateEmployeeRequest.getId());
		Employee employee = this.modelMapperService.forRequest().map(updateEmployeeRequest, Employee.class);
		this.employeeRepository.save(employee);
		UpdateEmployeeResponse updateEmployeeResponse = this.modelMapperService.forResponse().map(employee,
				UpdateEmployeeResponse.class);
		return new SuccessDataResult<UpdateEmployeeResponse>(updateEmployeeResponse, Messages.EmployeeUpdated);
	}

	@Override
	public DataResult<List<GetAllEmployeeResponse>> getAll() {
		List<Employee> employees = this.employeeRepository.findAll();
		List<GetAllEmployeeResponse> responses = employees.stream()
				.map(employee -> this.modelMapperService.forResponse().map(employee, GetAllEmployeeResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllEmployeeResponse>>(responses);
	}

	@Override
	public DataResult<GetEmployeeResponse> getById(int id) {
		checkIfEmployeeExistById(id);
		Employee employee = this.employeeRepository.findById(id).get();
		GetEmployeeResponse response = this.modelMapperService.forResponse().map(employee, GetEmployeeResponse.class);
		return new SuccessDataResult<GetEmployeeResponse>(response);
	}

	private void checkIfEmployeeExistById(int id) {
		if (!employeeRepository.existsById(id)) {
			throw new BusinessException(Messages.EmployeeNotExists);
		}
	}

	private void checkIfEmployeeExistByNationalIdentity(String nationalIdentity) {
		if (employeeRepository.existsByNationalIdentity(nationalIdentity)) {
			throw new BusinessException(Messages.EmployeeExists);
		}
	}

	private LocalDate stringToLocalDate(String dateOfBirth) {
		return LocalDate.parse(dateOfBirth);
	}

}
