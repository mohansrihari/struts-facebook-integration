package com.mohansrihari.facebook;

public interface FacebookParameterProvider {
	String AUTH_CODE		= "code";
	String SIGNED_REQUEST	= "signed_request";
	String FACEBOOK_TOKEN	= "facebookToken";

	String getParameter(final String paramName);
	Object getSessionAttribute(String paramName);
}
