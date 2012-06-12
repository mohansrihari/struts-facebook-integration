package com.mohansrihari.common;

import java.util.HashMap;



public class Context{
	public static String facebookAppId     = "";
	public static String facebookAppSecret  = "";
	public static String facebookAppChannelURL = "";
	public static String facebookAppLandingPageCanvas   = "";
	public static String facebookAppUrl             = "";
	public static HashMap<String, String> map=new HashMap<String, String>();

	private Context() {

	}
	public static void configureConstants(String facebookAppId
			,String facebookAppSecret
			,String facebookAppChannelURL
			,String facebookAppLandingPageCanvas
			,String facebookAppUrl) {
		Context.facebookAppId = facebookAppId;
		Context.facebookAppSecret = facebookAppSecret;
		Context.facebookAppChannelURL = facebookAppChannelURL;
		Context.facebookAppLandingPageCanvas = facebookAppLandingPageCanvas;
		Context.facebookAppUrl = facebookAppUrl;
		
		//keeping in HashMap
		map.put("facebookAppId", Context.facebookAppId);
		map.put("facebookAppSecret", Context.facebookAppSecret);
		map.put("facebookAppChannelURL", Context.facebookAppChannelURL);
		map.put("facebookAppLandingPageCanvas", Context.facebookAppLandingPageCanvas);
		map.put("facebookAppUrl", Context.facebookAppUrl);

	}
	public static synchronized String getString(String key)
	{
		if (map.containsKey(key)) return (String)map.get(key);
		return null;
	}
}
