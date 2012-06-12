package com.mohansrihari.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mohansrihari.service.FacebookService;
import com.mohansrihari.service.locator.ServiceLocator;
import com.mohansrihari.util.Util;

public class RequestAuth extends Action
{
    /**
     * Handles initial entry into FacebookUI application initializing
     * Facebook API and adding new account to the middle-tier if necessary.
     * Forwards to success if all goes well, failure if something goes wrong.
     * 
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {        
    	FacebookService facebookService = (FacebookService)Util.getService(ServiceLocator.FACEBOOK_SERVICE);
    	request.setAttribute("RequestAuthURL", facebookService.getAuthorizationUrl());
        return mapping.findForward("success");
    }
}
