package com.mohansrihari.service;

public interface SignatureService extends IBaseService{
	String getSignature(final String baseString, final String apiSecret);
	String getSignatureMethod();
}
