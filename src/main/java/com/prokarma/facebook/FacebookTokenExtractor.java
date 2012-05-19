package com.prokarma.facebook;

import com.prokarma.exception.ErrorType;
import com.prokarma.exception.FacebookException;
import com.prokarma.service.FacebookService;

public class FacebookTokenExtractor {
	
	private final FacebookService service;
	
	public FacebookTokenExtractor(final FacebookService newService) {
		this.service = newService;		
	}
	
	public FacebookToken extract(final FacebookParameterProvider paramProvider) throws Exception {
		final String oauthVerifier 	= paramProvider.getParameter(FacebookParameterProvider.AUTH_CODE);
		final String signedRequest 	= paramProvider.getParameter(FacebookParameterProvider.SIGNED_REQUEST);
              Object  object		= paramProvider.getSessionAttribute(FacebookParameterProvider.FACEBOOK_TOKEN);
		FacebookToken accessToken;

		if (signedRequest != null) {
			accessToken 	= service.extractAccessToken(signedRequest);
		} else if (oauthVerifier != null) {
			accessToken 	= service.getAccessToken(oauthVerifier);
		}else if(object!=null) {
			accessToken=(FacebookToken)object;
		}
		else {
			throw new FacebookException(ErrorType.AUTHERROR); 
		}		
		return accessToken;
	}
}
