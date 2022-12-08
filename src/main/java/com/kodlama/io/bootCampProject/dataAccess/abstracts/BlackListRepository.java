package com.kodlama.io.bootCampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.bootCampProject.entities.evaluations.BlackList;

public interface BlackListRepository extends JpaRepository<BlackList, Integer> {
	boolean existsByApplicantId(int id);
}
