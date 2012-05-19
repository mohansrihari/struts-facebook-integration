package com.prokarma;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.tiles.TilesRequestProcessor;

import com.prokarma.action.InitAction;
import com.prokarma.facebook.FacebookParameterProviderImpl;
import com.prokarma.facebook.FacebookToken;
import com.prokarma.facebook.FacebookTokenExtractor;
import com.prokarma.service.FacebookService;
import com.prokarma.service.locator.ServiceLocator;
import com.prokarma.util.Util;

public class CustomRequestProcessor extends TilesRequestProcessor
{     
	private FacebookTokenExtractor tokenExtractor;
	private static final String FACEBOOK_TOKEN = "facebookToken";
	private static final String REQUEST_AUTH="/requestAuth.do";
	private static final Logger logger = Logger.getLogger(InitAction.class);
    
	@Override protected boolean processPreprocess(HttpServletRequest request,
			HttpServletResponse response)
	{   
		Util.loggerMessage(logger,"processPreprocess","Start");
		
		String path = request.getServletPath();

		HttpSession session = request.getSession();
		
		if(path.equals(REQUEST_AUTH))
		{
			return true;
		}
		try
		{    
			FacebookService facebookService = (FacebookService)Util.getService(ServiceLocator.FACEBOOK_SERVICE);
			tokenExtractor	= new FacebookTokenExtractor(facebookService);
			try {
				FacebookToken facebookToken = tokenExtractor.extract( new FacebookParameterProviderImpl(request));
				session.setAttribute("facebookToken",facebookToken);
				
			} catch (com.prokarma.exception.FacebookException exception) {
				if (exception.isOAuthException()) {
					forceLogin(request, response);
					return false;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		catch(Exception e)
		{
			throw new RuntimeException(e.getMessage(), e);
		}
		Util.loggerMessage(logger,"processPreprocess","End");
		return true;
	}


	private void forceLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute(FACEBOOK_TOKEN);
		request.getRequestDispatcher(REQUEST_AUTH).forward(request,response);
	}
}
	