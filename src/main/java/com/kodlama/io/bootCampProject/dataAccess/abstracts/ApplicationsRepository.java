package com.kodlama.io.bootCampProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.bootCampProject.entities.applications.Applications;

public interface ApplicationsRepository extends JpaRepository<Applications, Integer> {
	List<Applications> getApplicationByBootcampId(int bootcampId);
}
