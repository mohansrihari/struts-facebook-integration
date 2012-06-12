package com.mohansrihari.model;

import java.util.List;
		
public class Work {

	private List<ExpDetails> data;

	public final List<ExpDetails> all() {
		return data;
	}

	public final void setData(final List<ExpDetails> data) {
		this.data = data;
	}

	@Override
	public final String toString() {
		return String.format("WorkHistory[data=%s]", data);
	}
}
