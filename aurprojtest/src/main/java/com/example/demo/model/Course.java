package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.UpdateTimestamp;


@Entity
public class Course {
	
	@Id
	@GeneratedValue
	private Long id;
	private String description;
	private String creator;
	private String skill;
	private String prerequisite;
	
	@UpdateTimestamp
	private Date lastupdated;

	public Date getlastupdated() {
		return lastupdated;
	}


	public void setlastupdated(Date lastupdated) {
		this.lastupdated = lastupdated;
	}


	public String getSkill() {
		return skill;
	}


	public void setSkill(String skill) {
		this.skill = skill;
	}


	public String getPrerequisite() {
		return prerequisite;
	}


	public void setPrerequisite(String prerequisite) {
		this.prerequisite = prerequisite;
	}


	public Course() {
		
	}
	
	
	public Long getid() {
		return id;
	}
	
	public void setid(Long id) {
		this.id = id;
	}
	
	
	public Course(Long id, String description, String creator, String skill, String prerequisite, Date lastupdated) {
		super();
		this.id = id;
		this.description = description;
		this.creator = creator;
		this.skill = skill;
		this.prerequisite = prerequisite;
		this.lastupdated = lastupdated;
	}


	public void setCourseId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
}
