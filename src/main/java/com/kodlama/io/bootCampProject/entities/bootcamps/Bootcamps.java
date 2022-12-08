package com.kodlama.io.bootCampProject.entities.bootcamps;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kodlama.io.bootCampProject.business.enums.BootcampState;
import com.kodlama.io.bootCampProject.entities.applications.Applications;
import com.kodlama.io.bootCampProject.entities.users.Instructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bootcamps")
public class Bootcamps {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "dateStart")
	private LocalDate dateStart;
	
	@Column(name = "dateEnd")
	private LocalDate dateEnd;
	
	@Enumerated(EnumType.STRING)
	private BootcampState bootcampState;
	
	@ManyToOne
	@JoinColumn(name = "instructorId")
	private Instructor instructor;

	@OneToMany(mappedBy = "bootcamp")
	private List<Applications> application;

}
