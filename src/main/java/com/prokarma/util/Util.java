package com.prokarma.util;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.prokarma.service.IBaseService;
import com.prokarma.service.locator.ServiceLocator;

public class Util {
	/**
	 * <p>
	 * This method locates the Service using the Service Name from ServiceLocator Class.
	 * </p>
	 * @param serviceName
	 * @return
	 */
	public static IBaseService getService(String serviceName){
	    return ServiceLocator.getInstance().getService(serviceName);
	}
	/**
	 *
	 * @param logger
	 * @param methodName
	 * @param mode
	 */
	public static void loggerMessage(Logger logger,String methodName,String mode){

		logger.debug("Method Name :: "+methodName+" :: "+mode);
	}
	/**
	 *
	 * @param logger
	 * @param methodName
	 * @param throwable
	 */
	public static void loggerErrorMessage(Logger logger,String methodName,Throwable throwable){

		logger.error("Method Name :: "+methodName, throwable);
	}
	   public static String getMessageFromResource(String key, HttpServletRequest request){
	        Locale loc = (Locale) request.getSession().getAttribute(org.apache.struts.Globals.LOCALE_KEY);
	        ResourceBundle resources = ResourceBundle.getBundle("com.prokarma.resources.ApplicationResources", loc );
	        return resources.getString(key);
	    }
}
