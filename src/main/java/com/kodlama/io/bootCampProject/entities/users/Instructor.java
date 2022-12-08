package com.kodlama.io.bootCampProject.entities.users;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kodlama.io.bootCampProject.entities.bootcamps.Bootcamps;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="instructors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Instructor extends User {
	
	@Column(name="companyName")
	private String companyName;
	@OneToMany(mappedBy = "instructor")
	private List<Bootcamps> bootcamps;
	
}
