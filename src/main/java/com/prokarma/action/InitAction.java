/**
 * 
 */
package com.prokarma.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.prokarma.exception.FacebookException;
import com.prokarma.facebook.FacebookClient;
import com.prokarma.facebook.FacebookToken;
import com.prokarma.model.User;
import com.prokarma.service.FacebookService;
import com.prokarma.service.locator.ServiceLocator;
import com.prokarma.util.Util;

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
