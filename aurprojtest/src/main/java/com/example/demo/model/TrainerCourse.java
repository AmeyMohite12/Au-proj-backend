package com.example.demo.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TrainerCourse {
	
	@Id
	@GeneratedValue
	private Long id;
	private Long courseid;
	private Long trainerid;
	public Long getId() {
		return id;
	}
	
	TrainerCourse(){}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCourseid() {
		return courseid;
	}
	public void setCourseid(Long courseid) {
		this.courseid = courseid;
	}
	public Long getTrainerid() {
		return trainerid;
	}
	public void setTrainerid(Long trainerid) {
		this.trainerid = trainerid;
	}
	public TrainerCourse(Long id, Long courseid, Long trainerid) {
		super();
		this.id = id;
		this.courseid = courseid;
		this.trainerid = trainerid;
	}
	
	
}
