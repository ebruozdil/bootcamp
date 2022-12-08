package com.kodlama.io.bootCampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.bootCampProject.entities.bootcamps.Bootcamps;

public interface BootcampRepository extends JpaRepository<Bootcamps, Integer> {
	

}
