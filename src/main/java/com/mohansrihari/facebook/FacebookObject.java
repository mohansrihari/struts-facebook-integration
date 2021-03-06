package com.mohansrihari.facebook;

public enum FacebookObject {

	ME("/me"), FRIENDS("/me/friends"), GROUPS("/me/groups");

	private String path;

	private FacebookObject(String path) {
		this.path = path;
	}

	public String getPath() {
		return this.path;
	}

	@Override
	public String toString() {
		return this.path;
	}
}
