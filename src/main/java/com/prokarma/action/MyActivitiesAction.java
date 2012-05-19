/**
 * 
 */
package com.prokarma.action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;

import com.prokarma.common.FacebookConstants.Fields;
import com.prokarma.exception.FacebookException;
import com.prokarma.facebook.FacebookClient;
import com.prokarma.facebook.FacebookToken;
import com.prokarma.model.ExpDetails;
import com.prokarma.model.Friend;
import com.prokarma.model.Friends;
import com.prokarma.model.User;
import com.prokarma.service.FacebookService;
import com.prokarma.service.locator.ServiceLocator;
import com.prokarma.util.Util;

/**
 * @author k Mohan Srihari
 *
 */
public class MyActivitiesAction extends DispatchAction {

	private static final Logger logger = Logger.getLogger(MyActivitiesAction.class);
	/**
     * To display personal information of the user from
     * Facebook API.
     * 
     */

    public ActionForward findMyDetails(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {   
    	Util.loggerMessage(logger,"findMyDetails","Start");
 		try {
			DynaActionForm personalInfo=(DynaActionForm)form;
			HttpSession session = request.getSession();
			
			FacebookService facebookService = (FacebookService)Util.getService(ServiceLocator.FACEBOOK_SERVICE);
			FacebookClient facebookClient=new FacebookClient(facebookService,(FacebookToken)session.getAttribute("facebookToken"));
			User user=facebookClient.getLoggedInUser();
			personalInfo.set("first_name",user.getFirstName());
			personalInfo.set("last_name",user.getLastName());
			personalInfo.set("birthday",user.getBirthday());
			personalInfo.set("gender",user.getGender());
			personalInfo.set("picture",user.getPicture());
			personalInfo.set("location",user.getLocation().getName());
			personalInfo.set("hometown",user.getHometown().getName());
			List<ExpDetails> expDetails=user.getWork();
			if(expDetails.size() > 0) {
				request.setAttribute("isWorking", true);
				request.setAttribute("work", expDetails);
			}
			
			Util.loggerMessage(logger,"findMyDetails","End");
		} catch (FacebookException fbe) {
			throw fbe;
		}
    	return mapping.findForward("personalInformation");
    }
	/**
	 * To display the list of friends request to this APP.
	 * 
	 */
	public ActionForward myFriends(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
			{   
		Util.loggerMessage(logger,"myFriends","Start");
		HttpSession session = request.getSession();
		try {

			FacebookService facebookService = (FacebookService)Util.getService(ServiceLocator.FACEBOOK_SERVICE);
			FacebookClient facebookClient=new FacebookClient(facebookService,(FacebookToken)session.getAttribute("facebookToken"));
			Friends friends=facebookClient.getFriends();

			List<Friend>friendList=friends.all();
			if(friendList.size() > 0) {
				request.setAttribute(Fields.facebookHasFriends, true);
				request.setAttribute(Fields.facebookFriends, friendList.subList(0, 10));
			}
		} catch (FacebookException fbe) {
			logger.error("Exception fetching friends list from Facebook: " + fbe, fbe);
			throw fbe;
		}

		Util.loggerMessage(logger,"myFriends","End");
		return mapping.findForward("friends");
			}
}
