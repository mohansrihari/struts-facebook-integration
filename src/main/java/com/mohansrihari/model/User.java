package com.mohansrihari.model;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@SerializedName("id")
	private String userId;
	@SerializedName("first_name")
	private String firstName;
	@SerializedName("last_name")
	private String lastName;
	private String oauthVerifier;
	private String name;
	private String gender;
	private String birthday;
	private String email;
	private String picture;
	private Location location;
	private Location hometown;
	private List<ExpDetails> work;
	
	
	
	public List<ExpDetails> getWork() {
		return work;
	}
	public void setWork(List<ExpDetails> work) {
		this.work = work;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Location getHometown() {
		return hometown;
	}
	public void setHometown(Location hometown) {
		this.hometown = hometown;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday =birthday ;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getOauthVerifier() {
		return oauthVerifier;
	}
	public void setOauthVerifier(String oauthVerifier) {
		this.oauthVerifier = oauthVerifier;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", name=" + name + ", gender="
				+ gender + ", birthday=" + birthday + "]";
	}



}
