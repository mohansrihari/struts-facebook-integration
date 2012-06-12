package com.mohansrihari.model;

import java.io.Serializable;

public class Employer implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
	

	@Override
	public String toString() {
		return "Employer [id=" + id + ", name=" + name + "]";
	}



}
