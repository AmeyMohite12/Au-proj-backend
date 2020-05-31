package com.example.demo.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.UpdateTimestamp;


@Entity
public class Materialversion {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Long material;
	private String creator;
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}

	@UpdateTimestamp
	private Date lastupdated;
	public Materialversion(Long id, String name, Long material, String creator , Date lastupdated) {
		super();
		this.id = id;
		this.name = name;
		this.material = material;
		this.lastupdated = lastupdated;
		this.creator = creator;
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
	public Long getMaterial() {
		return material;
	}
	public void setMaterial(Long material) {
		this.material = material;
	}
	public Date getLastupdated() {
		return lastupdated;
	}
	public void setLastupdated(Date lastupdated) {
		this.lastupdated = lastupdated;
	}

	Materialversion(){}
	
	
	
}
