package com.kodlama.io.bootCampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.bootCampProject.entities.users.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer>{
	boolean existsByNationalIdentity(String nationalIdentity);
}
