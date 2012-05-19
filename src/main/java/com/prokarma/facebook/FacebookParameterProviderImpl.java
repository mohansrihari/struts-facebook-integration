package com.prokarma.facebook;

import javax.servlet.http.HttpServletRequest;


public class FacebookParameterProviderImpl implements FacebookParameterProvider {
	final HttpServletRequest request;
	
	public FacebookParameterProviderImpl(final HttpServletRequest newRequest) {
		this.request = newRequest;
	}

	public String getParameter(final String paramName) {
		return request.getParameter(paramName);
	}
	public Object getSessionAttribute(final String paramName) {
		if(request.getSession()==null)return null;
		return request.getSession().getAttribute(paramName);
	}

}
