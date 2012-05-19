package com.prokarma;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;

import com.prokarma.exception.FacebookException;
import com.prokarma.model.FacebookError;
import com.prokarma.util.Util;

public class FacebookExceptionHandler extends ExceptionHandler
{  private static final Logger logger = Logger.getLogger(FacebookExceptionHandler.class);
   private static final String FACEBOOK_TOKEN = "facebookToken";

	public ActionForward execute(Exception ex, ExceptionConfig ae,
			ActionMapping mapping, ActionForm formInstance,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException
	{
		ActionForward forward = super.execute(ex, ae, mapping, formInstance, request, response);
		request.setAttribute("exception", ex);
		
		String logMsg = "Exception occurred " + ex.getMessage();
		if(FacebookException.class.isAssignableFrom(ex.getClass()))
		{
		    FacebookException fbe = (FacebookException) ex;
		    FacebookError facebookError = fbe.getoFacebookError();
		    logMsg += String.format("FacebookError",facebookError.getMessage());
		}
		
		if(FacebookException.class.isAssignableFrom(ex.getClass()))
		{
		   Util.loggerErrorMessage(logger, "GenericExceptionHandler -Execute", ex);
		}
		    
		logger.error(logMsg, ex);
		request.getSession().removeAttribute(FACEBOOK_TOKEN);
		return forward;
	}

}
