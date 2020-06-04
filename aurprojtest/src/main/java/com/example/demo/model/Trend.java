package com.example.demo.model;





public class Trend {
	private String name;
	private Long value;
	
	Trend(){
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}
	public Trend(String name, Long value) {
		super();
		this.name = name;
		this.value = value;
	}
	
}
