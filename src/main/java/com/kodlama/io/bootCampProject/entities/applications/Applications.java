package com.kodlama.io.bootCampProject.entities.applications;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kodlama.io.bootCampProject.business.enums.ApplicationState;
import com.kodlama.io.bootCampProject.entities.bootcamps.Bootcamps;
import com.kodlama.io.bootCampProject.entities.users.Applicant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "applications")
public class Applications {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Enumerated(EnumType.STRING)
	private ApplicationState applicationState;
	@ManyToOne()
	@JoinColumn(name = "aplicantId")
	private Applicant applicant;
	@ManyToOne()
	@JoinColumn(name = "bootcampId")
	private Bootcamps bootcamp;

}
