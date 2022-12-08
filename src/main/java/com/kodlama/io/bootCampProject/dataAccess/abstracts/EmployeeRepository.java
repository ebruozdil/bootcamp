package com.kodlama.io.bootCampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.bootCampProject.entities.users.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	boolean existsByNationalIdentity(String nationalIdentity);
}
