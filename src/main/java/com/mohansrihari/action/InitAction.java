/**
 * 
 */
package com.mohansrihari.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.mohansrihari.exception.FacebookException;
import com.mohansrihari.facebook.FacebookClient;
import com.mohansrihari.facebook.FacebookToken;
import com.mohansrihari.model.User;
import com.mohansrihari.service.FacebookService;
import com.mohansrihari.service.locator.ServiceLocator;
import com.mohansrihari.util.Util;

/**
 * @author kmohan
 *
 */
public class InitAction extends Action {
	/**
     * Handles initial entry into FacebookUI application initializing
     * Facebook API.
     * 
     */
	 private static final Logger logger = Logger.getLogger(InitAction.class);

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {   
    	Util.loggerMessage(logger,"InitAction-execute","Start");
 		try {
			DynaActionForm personalInfo=(DynaActionForm)form;
			HttpSession session = request.getSession();
			
			FacebookService facebookService = (FacebookService)Util.getService(ServiceLocator.FACEBOOK_SERVICE);
			FacebookClient facebookClient=new FacebookClient(facebookService,(FacebookToken)session.getAttribute("facebookToken"));
			User user=facebookClient.getLoggedInUser();
			personalInfo.set("name",user.getName());
			request.setAttribute("FeedDialogType", "Welcome");
    	    
 		} catch (FacebookException e) {
			throw e;
		}
    	Util.loggerMessage(logger,"InitAction-execute","End");
    	return mapping.findForward("success");
    }

}
