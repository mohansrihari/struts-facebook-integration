package com.mohansrihari.model;

import java.io.Serializable;

public class ExpDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	private Employer employer;
	private Location location;
	private String start_date;
	private String end_date;
	
	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	
	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public Employer getEmployer() {
		return employer;
	}



	public void setEmployer(Employer employer) {
		this.employer = employer;
	}



	public Location getLocation() {
		return location;
	}



	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "ExpDetails [employer=" + employer + ", location=" + location
				+ ", start_date=" + start_date + ", end_date=" + end_date + "]";
	}




}
