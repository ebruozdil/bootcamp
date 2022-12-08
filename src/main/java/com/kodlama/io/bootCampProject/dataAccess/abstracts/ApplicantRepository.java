package com.kodlama.io.bootCampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.bootCampProject.entities.users.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {
	boolean existsByNationalIdentity(String nationalIdentity);
}
