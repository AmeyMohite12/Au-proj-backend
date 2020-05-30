package com.example.demo.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.UpdateTimestamp;


@Entity
public class Material {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@UpdateTimestamp
	private Date lastupdated;
	
	Material(){}
	
	
	public Material(Long id, String name, Date lastupdated) {
		super();
		this.id = id;
		this.name = name;
		this.lastupdated = lastupdated;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public Date getlastupdated() {
		return lastupdated;
	}
	public void setlastupdated(Date lastupdated) {
		this.lastupdated = lastupdated;
	}
	
}
