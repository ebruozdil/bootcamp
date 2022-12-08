package com.kodlama.io.bootCampProject.entities.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="employeies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends User{
	
	@Column(name="position")
	private String position;
	
}
