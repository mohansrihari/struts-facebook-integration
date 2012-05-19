package com.prokarma.service;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Token;

import com.prokarma.facebook.FacebookToken;

public interface FacebookService extends IBaseService{
	
	FacebookToken extractAccessToken(final String signedRequest) throws Exception;
	FacebookToken getAccessToken(final String oauthVerifier);
	void signRequest(final Token accessToken, final OAuthRequest request);
	String getAuthorizationUrl();
}
